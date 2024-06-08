package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataBase.DataBase;
import model.Question;

public class QuestionDAO {

	DataBase db = new DataBase();
	Connection con = db.getConnection();

    private static final String INSERT_QUESTION = "INSERT INTO questions" + "  (question) VALUES " +
        " (?);";

    private static final String SELECT_QUESTION_BY_ID = "select id,question from questions where id =?;";
    private static final String SELECT_ALL_QUESTION = "select * from questions;";
    private static final String DELETE_QUESTION = "delete from questions where id = ?;";
    private static final String UPDATE_QUESTION = "update questions set question = ? where id = ?;";

    public QuestionDAO() {}

    

    public void insertQuestion(Question question) throws SQLException {
    	Connection con = db.getConnection();
    	try (Connection connection = con; 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUESTION)) {
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Question selectQuestion(int id) {
    	Connection con = db.getConnection();
    	Question question = null;
        try (Connection connection = con;
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTION_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int idQ = rs.getInt("id");
                String questions = rs.getString("question");
                question = new Question(idQ, questions);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return question;
    }

    public List < Question > selectAllQuestions() {
    	Connection con = db.getConnection();
        List < Question > questions = new ArrayList < > ();
        
        try (Connection connection = con;

            
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUESTION);) {
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();

           
            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                questions.add(new Question(id,question));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return questions;
    }

    public boolean deleteQuestion(int id) throws SQLException {
    	Connection con = db.getConnection();
        boolean rowDeleted;
        try (Connection connection = con; PreparedStatement statement = connection.prepareStatement(DELETE_QUESTION);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateQuestion(Question question) throws SQLException {
    	Connection con = db.getConnection();
        boolean rowUpdated;
        try (Connection connection = con; PreparedStatement statement = connection.prepareStatement(UPDATE_QUESTION);) {
        	statement.setString(1, question.getQuestion());
        	statement.setInt(2, question.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
