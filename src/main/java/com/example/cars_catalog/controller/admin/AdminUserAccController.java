package com.example.cars_catalog.controller.admin;

import com.example.cars_catalog.controller.dto.user.update.request.UpdateUserRequestDto;
import com.example.cars_catalog.controller.dto.user.update.response.UpdateUserResponseDto;
import com.example.cars_catalog.model.User;
import com.example.cars_catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class AdminUserAccController {

    private final UserService userService;

    @GetMapping
    public List<User> readAll() {
        return userService.readAll();
    }

    @PutMapping(value = "/{id}")
    public UpdateUserResponseDto update(@Valid @RequestBody UpdateUserRequestDto updateUserRequestDto, @PathVariable long id) {
        return userService.updateById(updateUserRequestDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable long id) {
        return userService.deleteById(id);
    }

}
