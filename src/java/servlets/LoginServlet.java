package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String logout = request.getParameter("logout");
        
        if (logout == null) {
            session.invalidate();
            request.setAttribute("loginMsg", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        if(username == null || username.equals("")) {
            request.setAttribute("usernameErrorMsg", "You must enter a username");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        String password = request.getParameter("password");
        if(password == null || password.equals("")) {
            request.setAttribute("passwordErrorMsg", "You must enter a password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        AccountService accountService = new AccountService();
        User user = accountService.login(username, password);
        
        if (user == null) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("loginMsg", "Invalid Credentials");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        
    }
}
