package com.example.ecf3echec.controller;

import com.example.ecf3echec.exception.PlayerFoundException;
import com.example.ecf3echec.exception.PlayerNotFoundException;
import com.example.ecf3echec.service.PlayerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private HttpServletResponse response;

    @GetMapping("signin")
    public ModelAndView signIn() {
        ModelAndView mv = new ModelAndView("signin");
        return mv;
    }

    @PostMapping("signin")
    public String signUp(@RequestParam String email, @RequestParam String password) throws PlayerNotFoundException, IOException {
        if (playerService.signIn(email, password)) {
            return "redirect:/";
        }
        return null;
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ModelAndView handlePlayerNotFound(PlayerNotFoundException ex) {
        ModelAndView mv = new ModelAndView("signin");
        mv.addObject("message", ex.getMessage());
        return mv;
    }

    @GetMapping("signup")
    public ModelAndView postSignIn() {
        ModelAndView mv = new ModelAndView("signup");
        return mv;
    }

    @PostMapping("signup")
    public String postSignUp(@RequestParam String name, @RequestParam String email, @RequestParam String password) throws PlayerFoundException, IOException {
        if (playerService.signUp(name, email, password)) {
            return "redirect:/user/signin";
        }
        return null;
    }

    @ExceptionHandler(PlayerFoundException.class)
    public ModelAndView handlePlayerFound(PlayerFoundException ex) {
        ModelAndView mv = new ModelAndView("signup");
        mv.addObject("message", ex.getMessage());
        return mv;
    }
}
