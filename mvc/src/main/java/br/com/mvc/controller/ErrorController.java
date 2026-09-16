package br.com.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice 
public abstract class ErrorController {

    @ExceptionHandler(Exception.class)
    public String handleError(Exception ex, Model model){
        model.addAttribute("mensagem", ex.getMessage());
        return "error";
    }
}
