package com.example.cars_catalog.controller.auth;

import com.example.cars_catalog.model.ERole;
import com.example.cars_catalog.model.Role;
import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute(name = "userModel") UserModel userModel, Model model) {
        model.addAttribute("userModel", userModel);
        userService.create(new UserModel(userModel.getName(), userModel.getEmail(),
                userModel.getPassword(), new HashSet<Role>()));
        return "redirect:/home";
    }

}
