package com.example.cars_catalog.controller.user;

import com.example.cars_catalog.model.Role;
import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class UserAccountController {

    private final UserService userService;


    public UserAccountController(UserService userService) {
        this.userService = userService;
    }

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
    public String updateAccount(@ModelAttribute(value = "user") UserModel userModel, @PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userModel);
        userService.update(new UserModel(id, userModel.getName(), userModel.getEmail(),
                userModel.getPassword(), Role.USER), id);
        return "userUpdateAccount";
    }

    @RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/deleteAccount/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/authorization";
    }

}
