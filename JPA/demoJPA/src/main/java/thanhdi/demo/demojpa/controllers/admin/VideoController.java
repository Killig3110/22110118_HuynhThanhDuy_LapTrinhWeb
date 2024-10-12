package thanhdi.demo.demojpa.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import thanhdi.demo.demojpa.entities.Category;
import thanhdi.demo.demojpa.entities.Video;
import thanhdi.demo.demojpa.services.ICategoryServices;
import thanhdi.demo.demojpa.services.IVideoServices;
import thanhdi.demo.demojpa.services.Implement.CategoryServicesImpl;
import thanhdi.demo.demojpa.services.Implement.VideoServicesImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static thanhdi.demo.demojpa.controllers.Const.DIR;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,  // 10MB
        maxFileSize = 1024 * 1024 * 50,       // 50MB
        maxRequestSize = 1024 * 1024 * 250)   // 250MB
@WebServlet(name = "VideoController", value = {"/admin/video/listvideo", "/admin/video/edit", "/admin/video/update",
        "/admin/video/insert", "/admin/video/add", "/admin/video/delete"})
public class VideoController extends HttpServlet {
    public IVideoServices videoServices = new VideoServicesImpl();
    public ICategoryServices categoryServices = new CategoryServicesImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();

        if (url.contains("/admin/video/listvideo")) {
            String keyword = req.getParameter("search");
            List<Video> listvideo;
            if (keyword != null && !keyword.isEmpty()) {
                listvideo = videoServices.findByTitle(keyword);
            } else
                listvideo = videoServices.findAll();
            req.setAttribute("listvideo", listvideo);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/video/edit")) {
            Video video = videoServices.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("video", video);
            List<Category> listCategory = categoryServices.findAll();
            req.setAttribute("listcategory", listCategory);
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
        } else if (url.contains("/admin/video/insert")) {
            List<Category> listCategory = categoryServices.findAll();
            req.setAttribute("listcategory", listCategory);
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/video/delete")) {
            videoServices.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect(req.getContextPath() + "/admin/video/listvideo");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();

        if (url.contains("/admin/video/update")) {
            Video video = new Video();
            video.setVideoid(Integer.parseInt(req.getParameter("videoid")));
            video.setDescription(req.getParameter("description"));
            video.setTitle(req.getParameter("videotitle"));
            video.setViews(Integer.parseInt(req.getParameter("views")));
            ICategoryServices categoryServices = new CategoryServicesImpl();
            Category category = categoryServices.findById(Integer.parseInt(req.getParameter("category")));
            video.setCategory(category);

            // Save old image
            Video videoOld = videoServices.findById(video.getVideoid());
            String oldPoster = videoOld.getPoster();
            String oldVideo = videoOld.getVideourl();
            // process image
            String uplaoadPath = DIR;
            File uploadDir = new File(uplaoadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();
            try {
                Part part = req.getPart("poster");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // change file name
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index+1);
                    String fname = System.currentTimeMillis() + "." + ext; // set file name with current time in milliseconds
                    // upload file
                    part.write(uplaoadPath + "/" + fname);
                    video.setPoster(fname);
                } else {
                    video.setPoster(oldPoster);
                }

                Part part2 = req.getPart("videourl");
                if (part2.getSize() > 0) {
                    String filename = Paths.get(part2.getSubmittedFileName()).getFileName().toString();
                    // change file name
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index+1);
                    String fname = System.currentTimeMillis() + "." + ext; // set file name with current time in milliseconds
                    // upload file
                    part2.write(uplaoadPath + "/" + fname);
                    video.setVideourl(fname);
                } else {
                    video.setVideourl(oldVideo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            videoServices.update(video);
            resp.sendRedirect(req.getContextPath() + "/admin/video/listvideo");
        } else if (url.contains("/admin/video/add")) {
            Video video = new Video();
            video.setDescription(req.getParameter("description"));
            video.setTitle(req.getParameter("videotitle"));
            video.setViews(Integer.parseInt(req.getParameter("views")));
            ICategoryServices categoryServices = new CategoryServicesImpl();
            Category category = categoryServices.findById(Integer.parseInt(req.getParameter("category")));
            video.setCategory(category);

            String uplaoadPath = DIR;
            File uploadDir = new File(uplaoadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();
            try {
                Part part = req.getPart("poster");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // change file name
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index+1);
                    String fname = System.currentTimeMillis() + "." + ext; // set file name with current time in milliseconds
                    // upload file
                    part.write(uplaoadPath + "/" + fname);
                    video.setPoster(fname);
                } else {
                    video.setPoster("default.jpg");
                }

                Part part2 = req.getPart("videourl");
                if (part2.getSize() > 0) {
                    String filename = Paths.get(part2.getSubmittedFileName()).getFileName().toString();
                    // change file name
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index+1);
                    String fname = System.currentTimeMillis() + "." + ext; // set file name with current time in milliseconds
                    // upload file
                    part2.write(uplaoadPath + "/" + fname);
                    video.setVideourl(fname);
                } else {
                    video.setVideourl("default.mp4");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            videoServices.insert(video);
            resp.sendRedirect(req.getContextPath() + "/admin/video/listvideo");
        }
    }
}
