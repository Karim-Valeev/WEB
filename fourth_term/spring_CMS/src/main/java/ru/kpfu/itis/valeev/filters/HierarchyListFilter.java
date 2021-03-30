package ru.kpfu.itis.valeev.filters;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.models.Website;
import ru.kpfu.itis.valeev.services.UserService;
import ru.kpfu.itis.valeev.services.WebsiteService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class HierarchyListFilter implements Filter {

    @Autowired
    private WebsiteService websiteService;

    @Autowired
    private UserService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getMethod().equals("GET")){
            //        Todo get name from HttpSession
            String login = "admin";

            User user = userService.getUser(login);

            List<Website> hierarchyList = websiteService.getHierarchyList(user);

            req.setAttribute("hierarchy", hierarchyList);
        }
        chain.doFilter(req, res);
    }
}
