package ru.kpfu.itis.valeev.helpers;

import java.time.LocalDateTime;

public class URLGenerationHelper {

    public  static String generateUrl(String login, String title){

        StringBuilder url = new StringBuilder();

        LocalDateTime now = LocalDateTime.now();

        url.append(login)
                .append("-")
                .append(title)
                .append("-")
                .append(now);

        return url.toString();
    }

}
