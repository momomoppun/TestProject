
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ShohinBean;

/**
 * Servlet implementation class ListControlServlet
 */
@WebServlet("/ListControlServlet")
public class ListControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
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
		ShohinDAO dao = new ShohinDAO();
		
		//ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		ArrayList<ShohinBean> list = (ArrayList<ShohinBean>)request.getAttribute("list");
		//String no = request.getParameter("no");
		list = dao.selectAll();
		String mode = request.getParameter("mode");
		String message = (String)request.getAttribute("message");
		
		request.setAttribute("list", list);
		request.setAttribute("mode", mode);
		request.setAttribute("message", message);
		
		if(mode.equals("1")) {
			request.setAttribute("no", 3);
		}else if(mode.equals("2")) {
			request.setAttribute("no", 4);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ichiran.jsp");
		rd.forward(request, response);
	}

}
