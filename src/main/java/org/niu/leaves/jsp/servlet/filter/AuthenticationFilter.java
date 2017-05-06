package org.niu.leaves.jsp.servlet.filter;

import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        if (!((HttpServletRequest) req).getRequestURI().contains("/login")) {

            //check if this user can log in this management system
            HttpSession session = ((HttpServletRequest) req).getSession();
            UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo) session.getAttribute("userWithDepartmentInfo");
            if (userWithDepartmentInfo != null && userWithDepartmentInfo.getFlag() == 1) {
                chain.doFilter(req, resp);
            } else {
                req.getRequestDispatcher("/unauthorized.jsp").forward(req, resp);
                return;
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
