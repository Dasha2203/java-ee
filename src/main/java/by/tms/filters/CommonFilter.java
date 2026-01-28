package by.tms.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class CommonFilter implements Filter {
    private static final List<String> PUBLIC_PATHS = Arrays.asList(
            "/login",
            "/register"
    );

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        String contextPath = httpRequest.getContextPath();
        String requestURI = httpRequest.getRequestURI();

        String path = requestURI.substring(contextPath.length());

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("account") != null);
        boolean isPublicPath = PUBLIC_PATHS.contains(path);

        if (isPublicPath) {
            if (isLoggedIn) {
                httpResponse.sendRedirect(contextPath + "/");
                return;
            }

            chain.doFilter(req, res);
            return;
        }

        if (!isLoggedIn) {
            httpResponse.sendRedirect(contextPath + "/login");
            return;
        }

        chain.doFilter(req, res);
    }
}
