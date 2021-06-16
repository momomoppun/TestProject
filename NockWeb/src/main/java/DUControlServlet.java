

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
 * Servlet implementation class DUControlServlet
 */
@WebServlet("/DUControlServlet")
public class DUControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("radio");
		String mode = request.getParameter("submit");
		
		if(mode.equals("削除")) {
			Errcheck err = new Errcheck();
			String err_message = err.notExitId(id);
		
			if(err_message == null) {
				//ShohinDAOのjoukenメソッドで削除するテーブルのデータを取得
				
				ShohinDAO dao = new ShohinDAO();
				ArrayList<ShohinBean> list = dao.jouken(id);
			
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/kakunin.jsp?submit=削除&id="+id+"&name="+list.get(0).getName()+"&price="+list.get(0).getPrice());
				rd.forward(request, response);
			}else {
				request.setAttribute("message", err_message);
				RequestDispatcher rd = request.getRequestDispatcher("/ListControlServlet?mode=2");
				rd.forward(request, response);
			}
		}
		else if(mode.equals("変更")) {
			Errcheck err = new Errcheck();
			String err_message = err.notExitId(id);
		
			if(err_message == null) {
				//ShohinDAOのjoukenメソッドで変更するテーブルのデータを取得
				ShohinDAO dao = new ShohinDAO();
				ArrayList<ShohinBean> list = dao.jouken(id);
			
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/mod.jsp?submit=変更&id="+id+"&name="+list.get(0).getName()+"&price="+list.get(0).getPrice());
				rd.forward(request, response);
			}else {
				request.setAttribute("message", err_message);
				RequestDispatcher rd = request.getRequestDispatcher("/ListControlServlet?mode=2");
				rd.forward(request, response);
			}
		}
	}

}
