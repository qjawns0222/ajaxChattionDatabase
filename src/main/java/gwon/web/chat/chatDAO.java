package gwon.web.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class chatDAO {
	private static chatDAO chatDAO;
	private chatDAO() {};
	public static chatDAO  getChatDAO() {
		if(chatDAO==null) {
			chatDAO=new chatDAO();
		}
		return chatDAO;
	}
	public void insert(String id,String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=Util.getConnection();
			pstmt=conn.prepareStatement("insert into chat values(?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, content);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}
	public List<chatVo> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<chatVo> list=new ArrayList<chatVo>();
		try {
			conn=Util.getConnection();
			pstmt=conn.prepareStatement("select * from chat order by id");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				chatVo chat=new chatVo(rs.getString("id"),rs.getString("content"));
				list.add(chat);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}

}
