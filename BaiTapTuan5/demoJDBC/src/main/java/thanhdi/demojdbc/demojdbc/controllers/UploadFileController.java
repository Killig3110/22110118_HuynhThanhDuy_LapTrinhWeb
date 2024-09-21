package thanhdi.demojdbc.demojdbc.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import thanhdi.demojdbc.demojdbc.models.UserModel;
import thanhdi.demojdbc.demojdbc.services.implement.UserServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import static thanhdi.demojdbc.demojdbc.controllers.UploadFileController.UPLOAD_DIRECTORY;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/uploadfile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadFileController extends HttpServlet {
    public static final String UPLOAD_DIRECTORY = "D:\\Lap_trinh_Web\\demoJDBC\\upload";
    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_FILENAME = "default.file";
    public static final String UPDATEFILE = "/views/updateaccount.jsp";

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
