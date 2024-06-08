package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	private Connection conn;

	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = java.sql.DriverManager.getConnection("jbdc:mysql;//localhost:3306/gamedb", "appuser", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addUser(String username, String pw, String salt) {
		String sql = "insert into useraccount (username, hashedpassword, salt) values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);
			stmt.setString(2, pw);
			stmt.setString(3, salt);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String getUserSalt(String username) {
		String result = "";
		String sql = "select salt from useraccount where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = rs.getString("salt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String getUserPasswordHash(String username) {
		String result = "";
		String sql = "select hashedpassword from useraccount where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next() ) {
				result = rs.getString("hashedpassword");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


}
