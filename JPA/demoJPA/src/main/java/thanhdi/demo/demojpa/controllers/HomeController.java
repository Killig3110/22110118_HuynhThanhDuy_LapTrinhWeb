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
        initData();
        request.getRequestDispatcher("/views/web/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("Hello " + request.getParameter("name"));

    }

    public void initData() {
        EntityManager enma = JPAConfig.getEntityManager();
        // check table "roles" have data
        enma.getTransaction().begin();
        TypedQuery<Role> query = enma.createQuery("SELECT r FROM Role r", Role.class);
        long count = query.getResultList().size();
        if (count == 0) {
            enma.persist(new Role(1, "admin"));
            enma.persist(new Role(2, "user"));

            enma.persist(new User("thanhdi", "1234", "thanhdi.png", "Thanh Duy", "thanhdi@gmail.com", "0123456789", 1, "2024-10-05"));
            enma.persist(new User("user1", "1234", "user1.png", "User", "user1@gmail.com", "0022446688", 2, "2024-10-05"));

            enma.persist(new Category("Music", "music.png", 1));
            enma.persist(new Category("Sport", "sport.png", 1));
            enma.persist(new Category("Game", "game.png", 1));
        }
        System.out.println("Init data success");
        enma.getTransaction().commit();
        enma.close();

    }
}