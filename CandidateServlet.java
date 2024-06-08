package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidateDAO;
import dao.QuestionDAO;
import dao.UserDAO;
import model.Answer;
import model.AnswerByCandidate;
import model.AnswerCandidate;
import model.Candidate;
import model.Question;
import model.User;

/**
 * Servlet implementation class CandidateServlet
 */
@WebServlet("/")
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private CandidateDAO candidateDAO;
	 private QuestionDAO questionDAO;
	 private UserDAO userDAO;
	 
	    public void init() {
	    	candidateDAO = new CandidateDAO();
	    	questionDAO = new QuestionDAO();
	    	userDAO = new UserDAO();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

        try {
            switch (action) {
           
                case "/details":
                	showCandidateDetails(request, response);
                    break;
                case "/test":
                	showQuestionsTest(request, response);
                    break;
                case "/newCandidate":
                    showNewForm(request, response);
                    break;
                case "/insertCandidate":
                    insertCandidate(request, response);
                    break;
                case "/deleteCandidate":
                    deleteCandidate(request, response);
                    break;
                case "/editCandidate":
                    showEditForm(request, response);
                    break;
                case "/updateCandidate":
                    updateCandidate(request, response);
                    break;
                case "/listCandidate":
                    listCandidate(request, response);
                    break;
                case "/newQuestion":
                    showNewFormQuestion(request, response);
                    break;
                case "/insertQuestion":
                    insertQuestion(request, response);
                    break;
                case "/deleteQuestion":
                    deleteQuestion(request, response);
                    break;
                case "/editQuestion":
                    showEditFormQuestion(request, response);
                    break;
                case "/updateQuestion":
                    updateQuestion(request, response);
                    break;
                case "/listQuestion":
                    listQuestion(request, response);
                    break;
                case "/insertAnswer":
                	insertAnswer(request, response);
                case "/loginPage":
                	showLoginPage(request, response);
                    break;
                case "/login":
                    login(request, response);
                    break;
                default:
                	listCandidateHome(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listCandidateHome(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Candidate > listCandidate = candidateDAO.selectAllCandidates();
		        request.setAttribute("listCandidate", listCandidate);
		        request.getRequestDispatcher("index-page.jsp").forward(request, response);
		       
	}

	
	private void showCandidateDetails(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Candidate existingCandidate = candidateDAO.selectCandidate(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("candidate-details.jsp");
		        request.setAttribute("candidate", existingCandidate);
		        dispatcher.forward(request, response);

	}

		   
	private void listCandidate(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Candidate > listCandidate = candidateDAO.selectAllCandidates();
		        request.setAttribute("listCandidate", listCandidate);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("list-candidate.jsp");
		        dispatcher.forward(request, response);
		       
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("candidate-form.jsp");
		        dispatcher.forward(request, response);
		  
	}

	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Candidate existingCandidate = candidateDAO.selectCandidate(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("candidate-form.jsp");
		        request.setAttribute("candidate", existingCandidate);
		        dispatcher.forward(request, response);

	}

		    
	private void insertCandidate(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String firstName = request.getParameter("firstName");
		        String lastName = request.getParameter("lastName");
		        String city = request.getParameter("city");
		        int age = Integer.parseInt(request.getParameter("age"));
		        String profession = request.getParameter("profession");
		        String politicalParty = request.getParameter("politicalParty");
		        String reason = request.getParameter("reason");
		        String about = request.getParameter("about");
		        Candidate newCandidate = new Candidate(firstName, lastName, city,age, profession, politicalParty, reason, about);
		        candidateDAO.insertCandidate(newCandidate);
		        response.sendRedirect("listCandidate");
		   
	}

		   
	private void updateCandidate(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String firstName = request.getParameter("firstName");
		        String lastName = request.getParameter("lastName");
		        String city = request.getParameter("city");
		        int age = Integer.parseInt(request.getParameter("age"));
		        String profession = request.getParameter("profession");
		        String politicalParty = request.getParameter("politicalParty");
		        String reason = request.getParameter("reason");
		        String about = request.getParameter("about");

		        Candidate newCandidate = new Candidate(id, firstName, lastName, city,age, profession, politicalParty, reason, about);

		        candidateDAO.updateCandidate(newCandidate);
		        response.sendRedirect("listCandidate");
		   
	}

		    
	private void deleteCandidate(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        candidateDAO.deleteCandidate(id);
		        response.sendRedirect("listCandidate");

		   
	}
	

	private void listQuestion(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
        List < Question > listQuestion = questionDAO.selectAllQuestions();
        request.setAttribute("listQuestion", listQuestion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-question.jsp");
        dispatcher.forward(request, response);
       
	}

	private void showNewFormQuestion(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("question-form.jsp");
	        dispatcher.forward(request, response);
	  
	}


	private void showEditFormQuestion(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Question existingQuestion = questionDAO.selectQuestion(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("question-form.jsp");
	        request.setAttribute("question", existingQuestion);
	        dispatcher.forward(request, response);
	
	}

    
private void insertQuestion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String question = request.getParameter("question");
        
        Question newQuestion = new Question(question);
        questionDAO.insertQuestion(newQuestion);
        response.sendRedirect("listQuestion");
   
}

   
private void updateQuestion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String question = request.getParameter("question");

        Question newQuestion = new Question(id, question);
        questionDAO.updateQuestion(newQuestion);
        response.sendRedirect("listQuestion");
   
}

    
	private void deleteQuestion(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        questionDAO.deleteQuestion(id);
	        response.sendRedirect("listQuestion");
	
	   
	}

	
	private void showQuestionsTest(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		 List < Question > listQuestion = questionDAO.selectAllQuestions();
	        request.setAttribute("listQuestion", listQuestion);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("questions.jsp");
	        dispatcher.forward(request, response);

	}
	
	private void insertAnswer(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		
		   
		     ArrayList<AnswerByCandidate> answerCandidate = new ArrayList<AnswerByCandidate>();
		     ArrayList<Answer> answerPublic = new ArrayList<Answer>();
		     
		     List < Question > listQuestion = questionDAO.selectAllQuestions();
		     List < Candidate > listCandidate = candidateDAO.selectAllCandidates();
		     
		     for(Question q: listQuestion) {
		    	 String value = request.getParameter("question-"+q.getId());
		    	 String valueAnswer = "unknown";
		    	 switch(value) {
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
		    	 
		    	 Answer answer = new Answer(q.getId(),valueAnswer,q.getQuestion());
		    	 
		    	 answerPublic.add(answer);
		     }
		     
		     for(Candidate c: listCandidate) {
		    	 AnswerByCandidate answerByCandidate = new AnswerByCandidate(c.getId(),c.getFirstName(),candidateDAO.selectAnswerCandidate(c.getId()));
		    	 answerCandidate.add(answerByCandidate);
		     }
		        
		     AnswerCandidate allAnswer = new AnswerCandidate(answerPublic,answerCandidate);
		      
		     request.setAttribute("allAnswer", allAnswer);
		     RequestDispatcher dispatcher = request.getRequestDispatcher("answers-result.jsp");
		     dispatcher.forward(request, response);
		   
		}
	
	private void showLoginPage(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		        dispatcher.forward(request, response);
		  
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        
		        String mp = request.getParameter("mp");
		        String login = request.getParameter("login");

		        System.out.print(mp + " updaaatttttt " +login);
		        User user = new User(login, mp);
		        boolean check = userDAO.checkUser(user);
		        
		        if(check) {
		        	listCandidate(request,response);
		        }else {
		        	response.sendRedirect("loginPage");
		        }
		        
		     
		   
		}
	
}
