//  需要添加JSON的jar包
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
public class J007_JuheDemo {
    public static final String DEF_CHARSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    // 配置申请的KEY
    public static final String APPKEY = "******************";
    public static void main(String[] args) {
        
    }
    public static void getRequest1() {
        String result = null;
        // 请求接口地址
        String url = "http://web.juhe.cn:8080/constellation/getAll";
        Map<String, String> params = new HashMap<String, String>(); //请求参数
        params.put("key", APPKEY);      //应用APPKEY
        params.put("consName", "");     //星座名称，如白羊座
        params.put("type", "");         //运势类型:today, tomorrow, week, nextweek, month, year
        try {
            result = net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if (object.getInt("error_code") == 0)
                System.out.println(object.get("result"));
            else
                System.out.println(object.get("error_code")+":"+object.get("reason"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String net(String strUri, Map<String, String> params, String method) throws Exception {
        HttpURLConnection con = null;
        BufferedReader br = null;
        String rs = null;
        try {
            StringBuilder st = new StringBuilder();
            if (method == null || method.equals("GET")) {
                strUri = strUri + "?" + urlencode(params);
            }
            URL url = new URL(strUri);
            con = (HttpURLConnection) url.openConnection();
            if (method == null || method.equals("GET")) {
                con.setRequestMethod("GET");
            } else {
                con.setRequestMethod("POST");
                con.setDoOutput(true);
            }
            con.setRequestProperty("User-agent", userAgent);
            con.setUseCaches(false);
            con.setConnectTimeout(DEF_CONN_TIMEOUT);
            con.setReadTimeout(DEF_READ_TIMEOUT);
            con.setInstanceFollowRedirects(false);
            con.connect();
            if (params != null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(con.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            InputStream is = con.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, DEF_CHARSET));
            String strRead = null;
            while ((strRead = br.readLine()) != null) {
                st.append(strRead);
            }
            rs = st.toString();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
            if (con != null)
                con.disconnect();
        }
        return rs;
    }
    public static String urlencode(Map<String, String> data) {
        StringBuilder st = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                st.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return st.toString();
    }
}
