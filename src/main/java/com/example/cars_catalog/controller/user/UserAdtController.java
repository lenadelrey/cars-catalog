package com.example.cars_catalog.controller.user;

import com.example.cars_catalog.model.AdtModel;
import com.example.cars_catalog.service.AdtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user/adt")
@RequiredArgsConstructor
public class UserAdtController {

    private final AdtService adtService;

    @GetMapping(value = "/createAdt")
    public String create(Model model) {
        model.addAttribute("adt", new AdtModel());
        return "createAdt";
    }

    @PostMapping(value = "/createAdt")
    public String create(@ModelAttribute(value = "adtModel") AdtModel adtModel, Model model) {
        model.addAttribute("adtModel", adtModel);
        adtService.create(adtModel);
        return "redirect:/home/readAdt/" + adtModel.getCar_id();
    }

    @GetMapping(value = "/readAdt/{id}")
    public String readAdt(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("adt", adtService.read(id));
        return "readAdt";
    }

    @GetMapping(value = "/updateAdt/{id}")
    public String updateAdt(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", adtService.read(id));
        return "userUpdateAdt";
    }

    @PostMapping(value = "/updateAdt/{id}")
    public String updateAdt(@ModelAttribute(value = "user") AdtModel adtModel, @PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("adtModel", adtModel);
        adtService.update(adtModel, id);
        return "userUpdateAdt";
    }

    @RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/deleteAdt/{id}")
    public String delete(@PathVariable("id") Long id) {
        adtService.delete(id);
        return "redirect:/home";
    }

}
