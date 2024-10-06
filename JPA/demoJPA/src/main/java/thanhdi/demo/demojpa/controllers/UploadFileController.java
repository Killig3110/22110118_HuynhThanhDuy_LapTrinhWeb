package thanhdi.demo.demojpa.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import thanhdi.demo.demojpa.services.Implement.UserServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import static thanhdi.demo.demojpa.controllers.Const.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/uploadfile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,  // 10MB
        maxFileSize = 1024 * 1024 * 50,       // 50MB
        maxRequestSize = 1024 * 1024 * 250)   // 250MB
public class UploadFileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
        String uploadPath = File.separator + DIR; //upload vào thư mục bất kỳ
        //String uploadPath = getServletContext().getRealPath("") + File.separator + DIR; //upload vào thư mục project

        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");

        //Up file
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();
        try {
            String fileName = "";
            for (Part part : request.getParts()) {
                fileName = getFileName(part);
                if (fileName.equals(DEFAULT_FILENAME))
                    break;
                part.write(uploadPath + File.separator + fileName);
            }
            String filePath = (uploadPath + File.separator + fileName).toString();
            request.setAttribute("message", "File " + fileName +  "đã được upload thành công vào " + filePath);
            UserServiceImpl userService = new UserServiceImpl();
            userService.updateFile(username, filePath);
        } catch (FileNotFoundException e) {
            request.setAttribute("message", "There was an error: " + e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/updateaccount?message=" + URLEncoder.encode((String) request.getAttribute("message"), "UTF-8"));
    }
}
