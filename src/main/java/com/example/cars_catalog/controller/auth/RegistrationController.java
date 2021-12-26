package com.example.cars_catalog.controller.auth;

import com.example.cars_catalog.model.Role;
import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String create(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "registration";
    }

    @PostMapping
    public String create(@ModelAttribute(value = "userModel") UserModel userModel, Model model) {
        model.addAttribute("userModel", userModel);
        userService.create(new UserModel(userModel.getName(), userModel.getEmail(),
                userModel.getPassword(), Role.USER));
        return "redirect:/home";
    }

}
