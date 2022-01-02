package com.example.cars_catalog.controller;

import com.example.cars_catalog.service.AdtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final AdtService adtService;

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("adt", adtService.readAll());
        model.addAttribute("user", null);
        return "home";
    }

    @GetMapping("/{limit}&{offset}")
    public String readAll(@PathParam(value = "limit") int limit, @PathParam(value = "offset") int offset, Model model) {
        model.addAttribute("adt", adtService.readAll(limit, offset));
        model.addAttribute("user", null);
        return "home";
    }

    @GetMapping(value = "/readAdt/{id}")
    public String readAdt(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("adt", adtService.read(id));
        return "readAdt";
    }

}
