package thanhdi.helloworld.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloController", value = "/HelloController")
public class HelloController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String ten = request.getParameter("ten");
        String ho = request.getParameter("ho");
        PrintWriter printW = response.getWriter();
        printW.println(ho + " " + ten);
        printW.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Set response content type
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        //Nhận dữ liệu từ request URL
        String ten = request.getParameter("ten");
        String ho = request.getParameter("ho");

        request.setAttribute("fname", ten);
        request.setAttribute("lname", ho);

//Hiển thị dữ liệu ra web bằng đối tượng PrintWriter
        PrintWriter out = response.getWriter();
        out.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>: "+ ho);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/test.jsp");
        rd.forward(request, response);
    }
}