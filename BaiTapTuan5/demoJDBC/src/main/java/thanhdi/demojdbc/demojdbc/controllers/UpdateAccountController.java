package thanhdi.demojdbc.demojdbc.controllers;

import com.mysql.cj.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import thanhdi.demojdbc.demojdbc.models.UserModel;
import thanhdi.demojdbc.demojdbc.services.implement.UserServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static thanhdi.demojdbc.demojdbc.controllers.UpdateAccountController.UPLOAD_DIRECTORY;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/updateaccount")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class UpdateAccountController extends HttpServlet{
    public static final String UPLOAD_DIRECTORY = "D:\\Lap_trinh_Web\\Bai_tap_lap_trinh_web\\BaiTapTuan5\\demoJDBC\\upload";
    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_FILENAME = "default.file";
    public static final String UPDATEACCOUNT = "/views/updateaccount.jsp";

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return DEFAULT_FILENAME;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String uploadPath = File.separator + UPLOAD_DIRECTORY; //upload vào thư mục bất kỳ
        //String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY; //upload vào thư mục project

        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");

        if (username == null || username.equals("") || fullname == null || fullname.equals("") || phone == null || phone.equals("")) {
            request.setAttribute("message", "Vui lòng nhập đầy đủ thông tin!");
            getServletContext().getRequestDispatcher("/views/result.jsp").forward(request, response);
            return;
        }
        if (phone.length() != 10) {
            request.setAttribute("message", "Số điện thoại phải có 10 chữ số!");
            getServletContext().getRequestDispatcher("/views/result.jsp").forward(request, response);
            return;
        }

        //Up file
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();
        try {
            String fileName = "";
            for (Part part : request.getParts()) {
                fileName = getFileName(part);
                part.write(uploadPath + File.separator + fileName);
            }
            String filePath = (uploadPath + File.separator + fileName).toString();
            UserServiceImpl userService = new UserServiceImpl();
            boolean check = userService.checkUpdateAccount(username, filePath, fullname, phone);
            if (!check) {
                request.setAttribute("message", "Cập nhật thông tin tài khoản thất bại!");
                File file = new File(filePath);
                file.delete();
                getServletContext().getRequestDispatcher("/views/result.jsp").forward(request, response);
                return;
            }
            UserModel user =  userService.findByUsername(username);
            request.setAttribute("message", "File " + fileName + " has uploaded successfully! \n" +
                    "Thông tin tài khoản đã được cập nhật! \n" +
                    "Username: " + user.getUsername() + ",\n" +
                    "Fullname: " + user.getFullname() + ",\n" +
                    "Phone: " + user.getPhone() + ",\n" +
                    "Images: " + user.getImages());
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        getServletContext().getRequestDispatcher("/views/result.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            UserModel user = (UserModel) session.getAttribute("account");
            String fullname = user.getFullname();
            System.out.println("Fullname: " + fullname); // In ra để kiểm tra

            // Giả sử bạn lấy được username từ fullname
            UserServiceImpl userService = new UserServiceImpl();
            String username = userService.getUserByFullName(fullname);

            System.out.println("Username: " + username); // In ra để kiểm tra

            request.setAttribute("username", username);
            // Chuyển tiếp đến trang JSP
            getServletContext().getRequestDispatcher(UPDATEACCOUNT).forward(request, response);
    }
}
