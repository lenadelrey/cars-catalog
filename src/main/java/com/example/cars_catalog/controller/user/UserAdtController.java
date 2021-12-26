package com.example.cars_catalog.controller.user;

import com.example.cars_catalog.model.AdtModel;
import com.example.cars_catalog.model.Role;
import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.service.AdtService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home/adt")
public class UserAdtController {

    private final AdtService adtService;

    public UserAdtController(AdtService adtService) {
        this.adtService = adtService;
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
        adtService.update(new AdtModel(id, adtModel.getModel(), adtModel.getDescription(),
                adtModel.getPrice(), adtModel.getYear(), adtModel.getUserModel()), id);
        return "userUpdateAdt";
    }

    @RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/deleteAdt/{id}")
    public String delete(@PathVariable("id") Long id) {
        adtService.delete(id);
        return "redirect:/home";
    }

}
