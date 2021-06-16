import java.util.ArrayList;

import bean.ShohinBean;
public class Errcheck {
	public String numCheck(String id, int kakaku) {
		String message=null;
		
		Integer kakaku_I = Integer.valueOf(kakaku);
		String kakaku_s = kakaku_I.toString();
		
		boolean id_check_1 = id.matches("[+-]?\\d*(\\.\\d+)?");
		boolean kakaku_check_1 = kakaku_s.matches("[+-]?\\d*(\\.\\d+)?");
		
		if(id_check_1 && kakaku_check_1) {
			int id_i = Integer.parseInt(id);
			
			if(id_i < 0 || kakaku < 0) {
				message = "IDと価格には正の整数を入力して下さい";
			}
			
		}else {
			message = "IDと価格には数字を入力してください";
		}
		
		return message;
	}
	
	public String exitId(String id) {
		String message=null;
		
		ShohinDAO dao = new ShohinDAO();
		
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		
		list = dao.jouken(id);
		
		if(list.size() != 0) {
			message = "既に存在しています";
		}
		
		return message;
	}
	
	public String notExitId(String id){
		String message=null;
		
		ShohinDAO dao = new ShohinDAO();
		
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		
		list = dao.jouken(id);
		
		if(list.size() == 0) {
			message = "対象データはありません";
		}else {
			
		}
		
		return message;
	}
}
