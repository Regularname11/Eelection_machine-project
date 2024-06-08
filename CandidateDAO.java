package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Candidate;
import dataBase.DataBase;

public class CandidateDAO {
	DataBase db = new DataBase();
	

    private static final String INSERT_CANDIDATE = "INSERT INTO candidates" + "  (firstName, lastName, city, age, profession, politicalParty, reason, about) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CANDIDATE_BY_ID = "select id,firstName, lastName, city, age, profession, politicalParty, reason, about from candidates where id =?";
    private static final String SELECT_ALL_CANDIDATES = "select * from candidates;";
    private static final String DELETE_CANDIDATE = "delete from candidates where id = ?;";
    private static final String UPDATE_CANDIDATE = "update candidates set firstName = ?,lastName= ?, city =? , age =? , profession =? , politicalParty =? , reason =? , about =? where id = ?;";

    private static final String SELECT_ANSWER_CANDIDATE = "select * from answer where idCandidate = ?;";
    public CandidateDAO() {}

    

    public void insertCandidate(Candidate candidate) throws SQLException {
    	Connection con = db.getConnection();
    	try (Connection connection = con; 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CANDIDATE)) {
            preparedStatement.setString(1, candidate.getFirstName());
            preparedStatement.setString(2, candidate.getLastName());
            preparedStatement.setString(3, candidate.getCity());
            preparedStatement.setInt(4, candidate.getAge());
            preparedStatement.setString(5, candidate.getProfession());
            preparedStatement.setString(6, candidate.getPoliticalParty());
            preparedStatement.setString(7, candidate.getReason());
            preparedStatement.setString(8, candidate.getAbout());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Candidate selectCandidate(int id) {
    	Connection con = db.getConnection();
    	Candidate candidate = null;
        try (Connection connection = con;
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CANDIDATE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
            	int idC = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String city = rs.getString("city");
                int age = rs.getInt("age");
                String profession = rs.getString("profession");
                String politicalParty = rs.getString("politicalParty");
                String reason = rs.getString("reason");
                String about = rs.getString("about");
                candidate = new Candidate(idC,firstName, lastName, city, age,profession,politicalParty,reason,about);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return candidate;
    }

    public List < Candidate > selectAllCandidates() {
    	Connection con = db.getConnection();
    	
        List < Candidate > candidates = new ArrayList < > ();
        try (Connection connection = con;
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CANDIDATES);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String city = rs.getString("city");
                int age = rs.getInt("age");
                String profession = rs.getString("profession");
                String politicalParty = rs.getString("politicalParty");
                String reason = rs.getString("reason");
                String about = rs.getString("about");
                candidates.add(new Candidate(id,firstName, lastName, city, age,profession,politicalParty,reason,about));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return candidates;
    }

    public boolean deleteCandidate(int id) throws SQLException {
    	Connection con = db.getConnection();
        boolean rowDeleted;
        try (Connection connection = con; PreparedStatement statement = connection.prepareStatement(DELETE_CANDIDATE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateCandidate(Candidate candidate) throws SQLException {
    	Connection con = db.getConnection();
        boolean rowUpdated;
        try (Connection connection = con; PreparedStatement statement = connection.prepareStatement(UPDATE_CANDIDATE);) {
        	statement.setString(1, candidate.getFirstName());
        	statement.setString(2, candidate.getLastName());
        	statement.setString(3, candidate.getCity());
        	statement.setInt(4, candidate.getAge());
        	statement.setString(5, candidate.getProfession());
        	statement.setString(6, candidate.getPoliticalParty());
        	statement.setString(7, candidate.getReason());
        	statement.setString(8, candidate.getAbout());
            statement.setInt(9, candidate.getId());

            rowUpdated = statement.executeUpdate() > 0;
            
            System.out.print(rowUpdated);
        }
        return rowUpdated;
    }

    public ArrayList<Answer> selectAnswerCandidate(int id) {
    	ArrayList<Answer> listAnswer = new ArrayList<Answer>();
    	Connection con = db.getConnection();
    	Answer answer = null;
       
        try (Connection connection = con;
           
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANSWER_CANDIDATE);) {
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();

           
            while (rs.next()) {
            	int idA = rs.getInt("id");
                String answerQ = rs.getString("answer");
                String valueAnswer = answerQ;
		    	 switch(answerQ) {
		    	 case "1" :
		    		 valueAnswer = "Disagree";
		    		 break;
		    	 case "2" :
		    		 valueAnswer = "Neutral";
		    		 break;
		    	 case "3" :
		    		 valueAnswer = "Agree";
		    		 break;
		         default:
		        	 break;
		    	 }
                int idQ = rs.getInt("idQuestion");
             
                PreparedStatement preparedStatement2 = connection.prepareStatement("select * from questions where id=?;");
                preparedStatement2.setInt(1, idQ);
                ResultSet rs2 = preparedStatement2.executeQuery();
                if(rs2.next()) {
                	String question = rs2.getString("question");
                	answer = new Answer(idA,valueAnswer, question);
                	listAnswer.add(answer);
                }
               
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listAnswer;
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
