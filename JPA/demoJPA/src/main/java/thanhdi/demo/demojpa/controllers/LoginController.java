package thanhdi.demo.demojpa.controllers;

import com.mysql.cj.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import thanhdi.demo.demojpa.entities.User;
import thanhdi.demo.demojpa.services.Implement.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;

        }
        // Check cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = request.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    response.sendRedirect(request.getContextPath() + "/home");
                    return;
                }
            }
        }
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String error = "";
        boolean hasError = false;

        if(username == null || username.isEmpty()) {
            error = "Username is required!";
            hasError = true;
        }
        if(password == null || password.isEmpty()) {
            error = "Password is required!";
            hasError = true;
        }
        User user = userService.checkLogin(username, password);
        System.out.println(user.getUsername());

        if(user == null) {
            error = "Username or password is incorrect!";
            hasError = true;
        }

        if(hasError) {
            error = "Tài khoản hoặc mật khẩu không đúng";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        } else {
            System.out.println("Login success");
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() + "/waiting");
        }

    }
}