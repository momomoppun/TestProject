import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ShohinBean;
import db.DBAccess;

public class ShohinDAO extends DBAccess{
	
	public ArrayList<ShohinBean> selectAll() {
		String sql = "select * from shohin";
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				ShohinBean bean = new ShohinBean(rs.getString("id"),rs.getString("name"),rs.getInt("kakaku"));
				
				list.add(bean);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	}
	
	public ArrayList<ShohinBean> jouken(String id) {
		String sql = "select * from shohin where id = ?";
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				ShohinBean bean = new ShohinBean(rs.getString("id"),rs.getString("name"),rs.getInt("kakaku"));
				
				list.add(bean);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	}
	
	public int insert(String yamanari, String name, int price) {
		int num = 0;
		String sql = "insert into shohin values(?, ?, ?)";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, yamanari);
			ps.setString(2, name);
			ps.setInt(3, price);
			
			int arata = ps.executeUpdate();//executeUpdate()は戻り値が更新した件数
			
			num = arata;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return num;
	}
	
	public int update(String id, String name, int price) {
		int num = 0;
		String sql = "update shohin set name = ?, kakaku = ? where id = ?";
		
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setInt(2, price);
			ps.setString(3, id);
			
			int nomura = ps.executeUpdate();//executeUpdate()は戻り値が更新した件数
			
			num = nomura;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return num;
	}
	
	public int delete(String id) {
		int num = 0;
		String sql = "delete from shohin where id = ?";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, id);
			
			int sakurada = ps.executeUpdate();//executeUpdate()は戻り値が更新した件数
			
			num = sakurada;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return num;
	}
	
}
