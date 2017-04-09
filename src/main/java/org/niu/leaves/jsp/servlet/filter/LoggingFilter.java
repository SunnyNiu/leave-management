package org.niu.leaves.jsp.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Sunny on 4/04/2017.
 */
@WebFilter(filterName = "LoggingFilter")
public class LoggingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        System.out.println("Filter executed:" + ((HttpServletRequest)req).getRequestURI());
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
