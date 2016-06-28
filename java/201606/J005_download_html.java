import java.util.*;
import java.io.*;
import java.net.*;
public class J005_download_html {
    public static void main(String[] args) {
        String url = "http://www.xjtu.edu.cn";
        String name = "xjtu.html";
        HttpURLConnection con = null;
        BufferedReader br = null;
        StringBuilder st = new StringBuilder();
        try {
            con = (HttpURLConnection)new URL(url).openConnection();
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while ((line=br.readLine()) != null) {
                st.append(line);
            }
        } catch (IOException e1) {
            System.out.println("net exception");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e2) {
                    System.out.println("br.close() exception");
                }
            }
        }
        File file = new File(name);
        if (file.exists())
            file.delete();
        PrintWriter pw = null;
        try {
            file.createNewFile();
            pw = new PrintWriter(new FileWriter(file, true));
            pw.write(st.toString());
            pw.flush();
        } catch (IOException e) {
            if (null != pw) {
                try {
                    pw.close();
                } catch(Exception e2) {
                    System.out.println("pw.close() exception");
                }
            }
        }
    }
}
