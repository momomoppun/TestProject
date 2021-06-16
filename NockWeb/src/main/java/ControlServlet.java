
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int mode = Integer.parseInt(request.getParameter("mode"));
		
		Errcheck err = new Errcheck();
		
		if(mode==1) {//確か登録の処理だったはず
			int price_i = Integer.parseInt(price);
			String message;
			message = err.numCheck(id, price_i);
			
			String message2;
			message2 = err.exitId(id);
			
			
			System.out.println("message = " +message);
			System.out.println("message2 = " +message2);
			
			if(message == null && message2 == null) //エラーがないとき
			{
				request.setAttribute("id", id);
				request.setAttribute("name", name);
				request.setAttribute("price", price);
				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/kakunin.jsp");
				rd.forward(request, response);
			}
			else//エラーがあるとき
			{
				//クエリ文字列にnullを入力すると、送り先ではnullという文字列だと判定されるようなので""(文字なし)に処理する
				if(message== null) {
					message = "";
				}
				if(message2==null) {
					message2= "";
				}
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/mod.jsp?message="+message+"&message2="+message2);
				rd.forward(request, response);
			}
		}
		else if(mode==2) {
			int price_i = Integer.parseInt(price);
			String message;
			message = err.numCheck(id, price_i);
			
			System.out.println("message = " +message);
			
			if(message == null) //エラーがないとき
			{
				request.setAttribute("id", id);
				request.setAttribute("name", name);
				request.setAttribute("price", price);
				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/kakunin.jsp?submit=変更");
				rd.forward(request, response);
			}
			else//エラーがあるとき
			{
				//クエリ文字列にnullを入力すると、送り先ではnullという文字列だと判定されるようなので""(文字なし)に処理する
				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/mod.jsp?message="+message);
				rd.forward(request, response);
			}
		}
		
		
		

	}

}
