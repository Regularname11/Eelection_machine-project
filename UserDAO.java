package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataBase.DataBase;
import model.User;

public class UserDAO {

	DataBase db = new DataBase();
	Connection con = db.getConnection();
	
	private static final String SELECT_USER = "select id from user where password =? and username =?;";
	
	public boolean checkUser(User user) throws SQLException {
		Connection con = db.getConnection();
        try (Connection connection = con;
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);) {
            preparedStatement.setString(1, user.getMp());
            preparedStatement.setString(2, user.getLogin());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) {
            	return true;
            }
            
        } catch (SQLException e) {
            return false;
        }
        return false;
    }
}
