package thanhdi.demojdbc.demojdbc.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import thanhdi.demojdbc.demojdbc.models.CategoryModel;
import thanhdi.demojdbc.demojdbc.services.ICategoryServices;
import thanhdi.demojdbc.demojdbc.services.implement.CategoryServicesImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static thanhdi.demojdbc.demojdbc.controllers.Const.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,  // 10MB
        maxFileSize = 1024 * 1024 * 50,       // 50MB
        maxRequestSize = 1024 * 1024 * 250)   // 250MB
@WebServlet(name = "CategoryController", value = {"/admin/categories", "/admin/category/edit", "/admin/category/update",
                "/admin/category/insert", "/admin/category/add", "/admin/category/delete"})
public class CategoryController extends HttpServlet {
    public static final long serialVersionUID = 1L;
    public ICategoryServices categoryServices = new CategoryServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();

        if (url.contains("/admin/categories")) {
            List<CategoryModel> list = categoryServices.findAll();
            req.setAttribute("listcate", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/category/edit")) {
            CategoryModel category = categoryServices.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("cate", category);

            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/insert")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            categoryServices.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();

        if (url.contains("/admin/category/update")) {
            CategoryModel category = new CategoryModel();
            category.setCategoryid(Integer.parseInt(req.getParameter("categoryid")));
            category.setCategoryname(req.getParameter("categoryname"));

            // Save old image
            CategoryModel cateOld = categoryServices.findById(category.getCategoryid());
            String oldImage = cateOld.getImages();
            // process image
            String uplaoadPath = DIR;
            File uploadDir = new File(uplaoadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();
            try {
                Part part = req.getPart("images");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // change file name
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index+1);
                    String fname = System.currentTimeMillis() + "." + ext; // set file name with current time in milliseconds
                    // upload file
                    part.write(uplaoadPath + "/" + fname);
                    category.setImages(fname);
                } else {
                    category.setImages(oldImage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            category.setStatus(Integer.parseInt(req.getParameter("status")));
            categoryServices.update(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        } else if (url.contains("/admin/category/add")) {
            CategoryModel category = new CategoryModel();
            category.setCategoryname(req.getParameter("categoryname"));
            category.setStatus(Integer.parseInt(req.getParameter("status")));
            String uplaoadPath = DIR;
            File uploadDir = new File(uplaoadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();
            try {
                Part part = req.getPart("images");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // change file name
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index+1);
                    String fname = System.currentTimeMillis() + "." + ext; // set file name with current time in milliseconds
                    // upload file
                    part.write(uplaoadPath + "/" + fname);
                    category.setImages(fname);
                } else {
                    category.setImages("avata.png");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            categoryServices.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }
}
