package com.example.cars_catalog.controller.admin;

import com.example.cars_catalog.model.AdtModel;
import com.example.cars_catalog.service.AdtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminAdtController {

    private final AdtService adtService;

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
