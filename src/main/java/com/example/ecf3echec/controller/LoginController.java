package com.example.ecf3echec.controller;

import com.example.ecf3echec.exception.PlayerFoundException;
import com.example.ecf3echec.exception.PlayerNotFoundException;
import com.example.ecf3echec.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final PlayerService playerService;

    @Autowired
    public LoginController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/signin")
    public String signIn(Model model) {
        model.addAttribute("error", "");
        return "signin";
    }

    @PostMapping("/signin")
    public String signUp(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) throws PlayerNotFoundException {
        if (playerService.signIn(email, password)) {
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("error", "Invalid email or password");
        return "redirect:/login/signin";
    }

    @GetMapping("signup")
    public String signUpForm(Model model) {
        model.addAttribute("error", "");
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignUp(@RequestParam String name, @RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) throws PlayerFoundException {
        try {
            playerService.createPlayer(name, email, password);
            return "redirect:/login/signin";
        } catch (PlayerFoundException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/login/signup";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login/signin";
    }


    @ExceptionHandler({PlayerNotFoundException.class, PlayerFoundException.class})
    public String handlePlayerExceptions(Exception ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/login/signin";
    }
}
