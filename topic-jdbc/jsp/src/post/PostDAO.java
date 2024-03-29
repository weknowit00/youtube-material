package post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class PostDAO {

	public int post(PostDTO post) {
		String SQL = "INSERT INTO test_sample VALUES (?, ?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, null);
			pstmt.setString(2, post.getTitle());
			pstmt.setString(3, post.getContent());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -1; // register failure
	}
	
	
}
