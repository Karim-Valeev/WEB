package ru.kpfu.itis.valeev.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class EdgeFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String browsers = req.getHeader("User-Agent");
        System.out.println("Filter is filtering!");
        if (browsers.contains("Edge")){
            System.out.println("Edge found");
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, res);
        } else {
            chain.doFilter(req, res);
        }

    }
}
