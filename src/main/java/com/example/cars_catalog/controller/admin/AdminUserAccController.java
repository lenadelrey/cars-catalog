package com.example.cars_catalog.controller.admin;

import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminUserAccController {

    private final UserService userService;

    @GetMapping(value = "/users/readAll")
    public String readAll(Model model) {
        model.addAttribute("users", userService.readAll());
        return "readAllUsers";
    }

    @GetMapping(value = "/users/updateAccount/{id}")
    public String updateAccount(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.read(id));
        return "updateAccount";
    }

    @PostMapping(value = "/users/updateAccount/{id}")
    public String updateAccount(@ModelAttribute(value = "user") UserModel userModel, @PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userModel);
        userService.update(userModel, id);
        return "updateAccount";
    }

    @RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/users/deleteAccount/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/readAllUsers";
    }

}
