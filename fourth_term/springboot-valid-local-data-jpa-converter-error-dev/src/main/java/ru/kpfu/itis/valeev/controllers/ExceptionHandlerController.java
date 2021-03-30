package ru.kpfu.itis.valeev.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.valeev.exceptions.NotExistingPostException;

import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.NotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotExistingPostException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView notFound(HttpServletRequest req, Exception exception) {
        ModelAndView mav = new ModelAndView();
        System.out.println("ERROR ACCUrED");
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("msg", exception.getMessage());
        mav.setViewName("error/not_found");
        return mav;
    }

}
