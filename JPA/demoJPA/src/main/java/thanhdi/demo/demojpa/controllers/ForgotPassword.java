package thanhdi.demo.demojpa.controllers;

import com.mysql.cj.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import thanhdi.demo.demojpa.services.Implement.UserServiceImpl;

import java.io.IOException;

import static thanhdi.demo.demojpa.controllers.Const.FORGOTPASSWORD;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/forgotpassword")
public class ForgotPassword extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String newpassword = req.getParameter("new-password");
        String repeatpassword = req.getParameter("repeat-password");
        UserServiceImpl service = new UserServiceImpl();
        String error = "";
        boolean hasError = false;
        if (!service.checkExistUser(username)) {
            error = "Tên đăng nhập không tồn tại!";
            hasError = true;
        }
        if (!service.checkExistEmail(email)) {
            error = "Email không tồn tại!";
            hasError = true;
        }
        if (!newpassword.equals(repeatpassword)) {
            error = "Mật khẩu không trùng khớp!";
            hasError = true;
        }
        if (hasError) {
            req.setAttribute("error", error);
            req.getRequestDispatcher(FORGOTPASSWORD).forward(req, resp);
        }
        else {
            service.updatePassword(username, newpassword);
            req.setAttribute("success", "Đổi mật khẩu thành công!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(FORGOTPASSWORD).forward(req, resp);
    }
}
