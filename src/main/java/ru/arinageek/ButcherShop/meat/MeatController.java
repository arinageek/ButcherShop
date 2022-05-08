package ru.arinageek.ButcherShop.meat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop")
public class MeatController {

    private final MeatService meatService;

    @Autowired
    public MeatController(MeatService meatService) {
        this.meatService = meatService;
    }

    @GetMapping
    public String getAllMeat(Model model) {
        model.addAttribute("meat", meatService.getAllMeat());
        return "showAllMeat";
    }

    @GetMapping(path = "/meat/{id}")
    public String getMeatById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("meat", meatService.getMeatById(id));
        return "showMeat";
    }

    @GetMapping(path = "/meat/new")
    public String addMeat(Model model) {
        model.addAttribute("meat", new Meat());
        return "newMeat";
    }

    @PostMapping(path = "/meat/new")
    public String addMeat(@ModelAttribute("meat") Meat meat) {
        meatService.addMeat(meat);
        return "redirect:/shop";
    }

    @PostMapping(path = "/meat/delete/{id}")
    public String deleteMeat(@PathVariable("id") Long id) {
        meatService.deleteMeat(id);
        return "redirect:/shop";
    }

}
