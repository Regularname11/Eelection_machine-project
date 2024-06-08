package app;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import third.Login;
import dao.dao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private dao dao;  

    public void init() {
        dao = new dao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login loginBean = new Login();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            if (dao.validate(loginBean)) {
                //HttpSession session = request.getSession();
               // session.setAttribute("username",username);
                response.sendRedirect("loginsuccess.jsp");
            } else {
               // HttpSession session = request.getSession();
              //  session.setAttribute("user", username);
                response.sendRedirect("form.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}