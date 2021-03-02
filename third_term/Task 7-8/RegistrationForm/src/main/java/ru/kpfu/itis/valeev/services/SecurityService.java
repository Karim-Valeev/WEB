package ru.kpfu.itis.valeev.services;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class SecurityService {

//    Todo парсинг csv с проверкой зареганности
//    ToDo если нет такого выдать ссылку на регистрацию
//    todo Если есть то в кабинет

//    ЭТО ПРОСТО ПРИМЕР
    private static final String EMAIL = "abc@abc.com";
    private static final String PASSWORD = "123";

    public static Map<String, Object> getUser(HttpServletRequest req) {
        if(isSigned(req)){
            Map<String, Object> user = new HashMap<>();
            user.put("email", req.getSession().getAttribute("email"));
            return user;
        }
        return null;
    }

    public static boolean isSigned(HttpServletRequest req) {
        return req.getSession().getAttribute("email") != null;
    }

    public static boolean signIn(HttpServletRequest req, String email, String password) {
        if (email.equals(EMAIL) && password.equals(PASSWORD)) {
            req.getSession().setAttribute("email", email);
            return true;
        }
        return false;
    }

    public static void signOut(HttpServletRequest req) {
        req.getSession().removeAttribute("email");
    }
}
