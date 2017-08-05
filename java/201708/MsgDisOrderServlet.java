/**
    这是一个Servlet
    目的是显示如果在msg中不做一些判断的话，
    会造成页面显示不正常
*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T
 */
public class MsgDisOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgDisOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	    String msg = request.getParameter("msg");
	    if (msg == null) msg = "default";
	    
	    System.out.println("msg --> " + msg);
	    
	    /**
	     *     msg --> '<body>'   显示不正常
	     *     msg --> '<body>"   显示不正常
	     */
	    
	    PrintWriter pw = new PrintWriter(response.getOutputStream());
	    
	    pw.println("<html>");
	    pw.println("<body>");
	    pw.println("<p>hello</p>");
	    pw.println("<input type=hidden name=msg value='" + msg + "' />");
	    pw.println("</body>");
	    pw.println("</html>");
	    
	    pw.flush();
	    pw.close();
	}

}
