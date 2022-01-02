package com.example.cars_catalog.controller.auth;

import com.example.cars_catalog.model.User;
import com.example.cars_catalog.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public User registration(@RequestBody User user) {
        return registrationService.create(user);
    }

//    @GetMapping
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("userModel", new UserModel());
//        return "registration";
//    }
//
//    @PostMapping
//    public String registration(@ModelAttribute(name = "userModel") UserModel userModel, Model model) {
//        model.addAttribute("userModel", userModel);
//        registrationService.create(userModel);
//        return "redirect:/home";
//    }

}
