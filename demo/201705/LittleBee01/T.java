package t;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T
 */
public class T extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String DEFAULT_FILE = "listen1705/save.txt";
	private static final String DEFAULT_PATH = "listen1705";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName = null, filePath = null, date = null;
		try {
			fileName = new String(request.getParameter("file").getBytes("iso8859-1"), "utf8");
			filePath = fileName.substring(0, fileName.lastIndexOf('/'));
			date = new String(request.getParameter("date").getBytes("iso8859-1"), "utf8");
		} catch (Exception e) {
			fileName = DEFAULT_FILE;
			filePath = DEFAULT_PATH;
			date = null;
		}
		if (! fileName.equals(DEFAULT_FILE)) {
			response.getWriter().append("only " + DEFAULT_FILE + " is ok!").flush();
			return;
		}
	    if (C.bashPath == null)
	    	C.bashPath = request.getSession().getServletContext().getRealPath("shell");
	    Process p = Runtime.getRuntime().exec("bash " + C.bashPath + "/cat.sh");
//	    Process p = Runtime.getRuntime().exec("whoami");
	    try {
			p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    StringBuilder st = new StringBuilder();
	    while (true) {
	    	String line = br.readLine();
	    	if (line == null) break;
	    	st.append(line);
	    	st.append("\r\n");
	    }
	    response.setHeader("content-disposition", "attachment;filename="+"data.txt");
	    OutputStream os = response.getOutputStream();
	    os.write(new String(st).getBytes());
	    os.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
