package ru.kpfu.itis.valeev.controllers;

import au.com.bytecode.opencsv.CSVWriter;
import ru.kpfu.itis.valeev.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Somebody send GET method");
        if(req.getParameter("status") != null){
            if(req.getParameter("status").equals("1")){
                req.setAttribute("message", "User has been created.");
//                Enumeration<String> en = req.getAttributeNames();
//                ArrayList<String> str = new ArrayList<>();
//                while (en.hasMoreElements()){
//                    str.add(en.nextElement());
//                }
//                System.out.println(str);

            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/templates/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        System.out.println("Somebody send POST method");
//        PrintWriter out = resp.getWriter();
//        String err = error();
        if(password.equals(req.getParameter("conf-password")) && password.length() >=8){

            String login = req.getParameter("login");
            String email = req.getParameter("email");
            Pattern pattern = Pattern.compile("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)");
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                User user = new User(login, password, email);
                this.saveToCSV(user);
                System.out.println("User have been saved!");
                resp.sendRedirect(req.getRequestURI()+"?status=1");
                return;
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/templates/error.jsp").forward(req, resp);
            }
        } else {
              getServletContext().getRequestDispatcher("/WEB-INF/templates/error.jsp").forward(req, resp);
        }
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);

    }

    public void saveToCSV(User user){
//        File file = new File(getServletContext().getRealPath("/users.csv"));
        File csvFile = new File(getServletContext().getRealPath("/") + "/WEB-INF/db/users.csv");
        System.out.println(csvFile);
        try {
            if(!csvFile.exists()){
                csvFile.createNewFile();
            }
            CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFile, true));
            String[] list = {user.getLogin(), user.getEmail(), user.getPassword()};
            System.out.println(Arrays.toString(list));
            csvWriter.writeNext(list);
            csvWriter.close();
//            return true;
        } catch (IOException e) {
//            return false;
            e.printStackTrace();
        }
    }

    public static String error(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"static/css/style.css\">\n" +
                "\n" +
                "    <script src=\"static/js/script.js\"></script>\n" +
                "    <title>Error</title>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"mid\">\n" +
                "        An error occured, please try again!\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
