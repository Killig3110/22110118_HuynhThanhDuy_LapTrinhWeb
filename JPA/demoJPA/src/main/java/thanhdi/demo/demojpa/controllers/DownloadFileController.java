package thanhdi.demo.demojpa.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import static thanhdi.demo.demojpa.controllers.Const.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(name = "DownloadFileController", value = {"/images", "/videos"})
public class DownloadFileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String fileName = req.getParameter("fname");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();

        if (url.contains("/images")) {
            File file = new File(DIR + "/" + fileName);
            resp.setContentType("images/jpeg");
            if (file.exists()) {
                IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
            }
        } else if (url.contains("/videos")) {
            File file = new File(DIR + "/" + fileName);
            resp.setContentType("video/mp4");
            if (file.exists()) {
                IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
            }
        }
    }
}
