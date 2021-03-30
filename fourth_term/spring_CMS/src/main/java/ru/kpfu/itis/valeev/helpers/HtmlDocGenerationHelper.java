package ru.kpfu.itis.valeev.helpers;

public class HtmlDocGenerationHelper {

    public  static String generateHtml(String title, String body){

        StringBuilder htmlDoc = new StringBuilder();

        htmlDoc.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>")

                .append(title)

                .append("</title>\n" +
                        "</head>\n" +
                        "<body>")

                .append(body)

                .append("</body>\n" +
                        "</html>\n");

        return htmlDoc.toString();
    }

}
