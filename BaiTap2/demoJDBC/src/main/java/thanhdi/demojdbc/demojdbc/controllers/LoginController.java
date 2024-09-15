package thanhdi.demojdbc.demojdbc.controllers;

import com.mysql.cj.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import thanhdi.demojdbc.demojdbc.models.UserModel;
import thanhdi.demojdbc.demojdbc.services.IUserServices;
import thanhdi.demojdbc.demojdbc.services.implement.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    IUserServices userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        String error = "";
        boolean hasError = false;
        boolean isRememberMe = false;
        if("on".equals(remember)) {
            isRememberMe = true;
        }

        if(username == null || username.isEmpty()) {
            error = "Username is required!";
            hasError = true;
        }

        if(password == null || password.isEmpty()) {
            error = "Password is required!";
            hasError = true;
        }

        IUserServices userService = new UserServiceImpl();
        UserModel user = userService.checkLogin(username, password);

        if(user == null) {
            error = "Username or password is incorrect!";
            hasError = true;
        }

        if(hasError) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);
            if(isRememberMe) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(30*60);
                response.addCookie(cookie);
                response.sendRedirect(request.getContextPath() + "/waiting");
            } else {
                error = "Tài khoản hoặc mật khẩu không đúng";
                request.setAttribute("alert", error);
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            }
        }

    }
}