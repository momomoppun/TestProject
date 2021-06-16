import java.util.ArrayList;

import bean.ShohinBean;

public class testDriver {

	public static void main(String[] args) {
		//一覧表示呼び出し
		//selectAll();
		//条件検索呼び出し
		//jouken();
		//項目を追加する
		//insert();
		//項目を更新する
		//update();
		//項目を削除する
		delete();
	}
	
	public static void selectAll() {
		ShohinDAO dao = new ShohinDAO();
		ArrayList<ShohinBean> list = dao.selectAll();
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).getId()+", ");
			System.out.print(list.get(i).getName()+", ");
			System.out.println(list.get(i).getPrice()+", ");
		}
		if(list.size()==0) {
			System.out.println("条件に合致したデータは存在しません");
		}
		
	}
	
	public static void jouken() {
		ShohinDAO dao = new ShohinDAO();
		ArrayList<ShohinBean> list = dao.jouken("00009");
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).getId()+", ");
			System.out.print(list.get(i).getName()+", ");
			System.out.println(list.get(i).getPrice()+", ");
		}
		if(list.size()==0) {
			System.out.println("条件に合致したデータは存在しません");
		}
		
	}
	
	public static void insert() {
		ShohinDAO dao = new ShohinDAO();
		
		//numには追加した行数が入ります
		int num = dao.insert("00011", "トマト", 125);
		
		if(num == 0) {
			System.out.println("追加できませんでした");
		}
		else {
			System.out.println("追加しました");
		}
	}
	
	public static void update() {
		ShohinDAO dao = new ShohinDAO();
		
		int num = dao.update("00011", "パイン", 1700);
		
		if(num == 0) {
			System.out.println("更新できませんでした");
		}
		else {
			System.out.println("更新しました");
		}
	}

	public static void delete() {
		ShohinDAO dao = new ShohinDAO();
		
		int num = dao.delete("00011");
		
		if(num == 0) {
			System.out.println("削除できませんでした");
		}
		else {
			System.out.println("削除しました");
		}
	}
}
