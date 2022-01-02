package com.example.cars_catalog.controller.user;

import com.example.cars_catalog.model.User;
import com.example.cars_catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserService userService;

    @GetMapping(value = "/read/{id}")
    public String read(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.read(id));
        return "readUserAccount";
    }

    @GetMapping(value = "/updateAccount/{id}")
    public String updateAccount(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.read(id));
        return "userUpdateAccount";
    }

    @PostMapping(value = "/updateAccount/{id}")
    public String updateAccount(@ModelAttribute(value = "user") User user, @PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", user);
        userService.update(user, id);
        return "userUpdateAccount";
    }

    @RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/deleteAccount/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/authorization";
    }

}
