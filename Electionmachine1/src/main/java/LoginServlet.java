

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electionmachine?useSSL=false", "root", "Y.moussaddak9");
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from login where username ='"+username+"' and password='"+password+"'");
		if(rs.next()) {
			response.sendRedirect("Home.html");
		}else {
			out.println("wrong password and or username :( ");
		}
		con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}


}

}
