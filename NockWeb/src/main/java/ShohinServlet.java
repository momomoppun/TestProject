
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ShohinServlet
 */
@WebServlet("/ShohinServlet")
public class ShohinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ShohinDAO dao = new ShohinDAO();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		int mode = Integer.parseInt(request.getParameter("mode"));
		
		if(mode==1) {	//登録の場合
			int num = dao.insert(id, name, price);
			
			if(num == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/mod.jsp");
				rd.forward(request, response);
			}else {
				System.out.println("登録完了");
				request.setAttribute("message", "登録されました");
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/mod.jsp?check=1");
				rd.forward(request, response);
			}
		}else if(mode==2) {		//変更の場合
			int num = dao.update(id, name, price);
			
			if(num == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/mod.jsp");
				rd.forward(request, response);
			}else {
				System.out.println("変更完了");
				request.setAttribute("message", "変更されました");
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/mod.jsp?submit=変更");
				rd.forward(request, response);
			}
		}else if(mode==3) {		//削除の場合
			int num = dao.delete(id);
			
			if(num == 0) {
				request.setAttribute("message", "何かしらの理由で削除できませんでした");
				RequestDispatcher rd = request.getRequestDispatcher("/ListControlServlet?mode=2");
				rd.forward(request, response);
			}else {
				System.out.println("削除完了");
				request.setAttribute("message", "削除されました");
				RequestDispatcher rd = request.getRequestDispatcher("/ListControlServlet?mode=2");
				rd.forward(request, response);
			}
		}
		
	}

}
