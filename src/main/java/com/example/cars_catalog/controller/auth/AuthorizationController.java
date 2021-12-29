package com.example.cars_catalog.controller.auth;


import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/authorization")
@RequiredArgsConstructor
public class AuthorizationController {

    private final UserService userService;

    @GetMapping
    public String showAuthForm(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "authorization";
    }

    @PostMapping
    public String authorization(@PathParam(value = "email") String email, @PathParam(value = "password") String password, Model model) {
        UserModel byEmail = userService.getByEmail(email);
        if (byEmail.getPassword().equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("message", "Password is incorrect");
        return "authorization";
    }

}
