package org.niu.leaves.jsp.servlet.filter;

import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.service.DepartmentService;
import org.niu.leaves.jsp.servlet.service.TitleService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AuthorizationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        DepartmentService departmentService = new DepartmentService();
        HttpSession session = ((HttpServletRequest) req).getSession();
        TitleService titleService = new TitleService();
        UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo) session.getAttribute("userWithDepartmentInfo");
        if (((HttpServletRequest) req).getRequestURI().contains("/approveRejectWithdrawn.do")) {
            try {
                List<UserWithDepartmentInfo> departmentInfoList = departmentService.queryAllDepartments();
                for (UserWithDepartmentInfo departmentInfo : departmentInfoList) {
                    if (departmentInfo.getManagerUserId() == userWithDepartmentInfo.getUserId()) {
                        chain.doFilter(req, resp);
                        return;
                    }
                }
                req.getRequestDispatcher("/unauthorized.jsp").forward(req, resp);
                return;
            } catch (SQLException ex) {
                req.getRequestDispatcher("/unauthorized.jsp").forward(req, resp);
                return;
            }
        } else if (((HttpServletRequest) req).getRequestURI().contains("/addNewMember")) {
            try {
                int levelId = titleService.getLevelId(userWithDepartmentInfo.getTitle());
                if (!(levelId == 1)) {
                    req.getRequestDispatcher("/unauthorized.jsp").forward(req, resp);
                    return;
                } else {
                    chain.doFilter(req, resp);
                }
            } catch (SQLException ex) {
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
