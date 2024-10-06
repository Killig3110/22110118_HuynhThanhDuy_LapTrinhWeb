package thanhdi.demo.demojpa.controllers;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import thanhdi.demo.demojpa.configs.JPAConfig;
import thanhdi.demo.demojpa.entities.Category;
import thanhdi.demo.demojpa.entities.Role;
import thanhdi.demo.demojpa.entities.User;

import java.io.IOException;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        request.getRequestDispatcher("/views/web/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("Hello " + request.getParameter("name"));

    }

    public void init() {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();

            // check table "roles" have data
            TypedQuery<Long> query = enma.createQuery("SELECT COUNT(r) FROM Role r", Long.class);
            Long count = query.getSingleResult();
            if (count == 0) {
                enma.persist(new Role("admin"));
                enma.persist(new Role("user"));

                enma.persist(new User("thanhdi", "1234", "thanhdi.png", "Thanh Duy", "thanhdi@gmail.com", "0123456789", 1, "2024-10-05"));
                enma.persist(new User("user1", "1234", "user1.png", "User", "user1@gmail.com", "0022446688", 2, "2024-10-05"));

                enma.persist(new Category("Music", "music.png", 1));
                enma.persist(new Category("Sport", "sport.png", 1));
                enma.persist(new Category("Game", "game.png", 1));
            }

            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }

    }
}