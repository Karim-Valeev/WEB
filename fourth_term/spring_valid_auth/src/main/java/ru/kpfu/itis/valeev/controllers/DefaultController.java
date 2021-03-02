package ru.kpfu.itis.valeev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class DefaultController {

    @RequestMapping(
            value = "/method_headers",
            headers = "user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36"
//            ,params = "my_param=1"
    )
    public String methodHeadersPtinter(@RequestHeader Map<String, String> headers, Model model){
        model.addAttribute("map", headers);
        System.out.println(headers.entrySet());
        return "method-headers";
    }

}
