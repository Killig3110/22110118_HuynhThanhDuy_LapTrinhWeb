package thanhdi.demo.demojpa.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thanhdi.demo.demojpa.entities.User;

import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resq = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        User user = (User) obj;
        if (user != null && user.getRoleid() == 1) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resq.sendRedirect(req.getContextPath() + "/logout");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
