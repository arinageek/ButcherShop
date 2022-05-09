package ru.arinageek.ButcherShop.meat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.arinageek.ButcherShop.client.Client;
import ru.arinageek.ButcherShop.client.ClientService;
import ru.arinageek.ButcherShop.session.SessionRepository;
import ru.arinageek.ButcherShop.session.SessionService;

@Controller
@RequestMapping("/shop")
public class MeatController {

    private final MeatService meatService;
    private final SessionService sessionService;

    @Autowired
    public MeatController(MeatService meatService, SessionService sessionService) {
        this.meatService = meatService;
        this.sessionService = sessionService;
    }

    @GetMapping
    public String getAllMeat(Model model) {
        model.addAttribute("meat", meatService.getAllMeat());
        model.addAttribute("filters", new Filters());
        model.addAttribute("client", sessionService.getCurrentUser());
        return "showAllMeat";
    }

    @PostMapping(path = "/meat/filterPrice")
    public String getMeatWithPriceLessThen(@ModelAttribute("filters") Filters filters, Model model) {
        model.addAttribute("meat", meatService.getMeatWithPriceLessThen(filters.getMaxPrice()));
        model.addAttribute("filters", filters);
        model.addAttribute("client", sessionService.getCurrentUser());
        return "showAllMeat";
    }

    @GetMapping(path = "/meat/{id}")
    public String getMeatById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("meat", meatService.getMeatById(id));
        model.addAttribute("client", sessionService.getCurrentUser());
        return "showMeat";
    }

    @GetMapping(path = "/meat/new")
    public String addMeat(Model model) {
        model.addAttribute("meat", new Meat());
        model.addAttribute("client", sessionService.getCurrentUser());
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
