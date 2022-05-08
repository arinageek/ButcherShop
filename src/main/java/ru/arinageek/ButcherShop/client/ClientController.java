package ru.arinageek.ButcherShop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", clientService.getAllUsers());
        return "showUsers";
    }

    @GetMapping(path = "/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", clientService.getUserById(id));
        return "showUser";
    }

    @GetMapping(path = "/new")
    public String addUser(Model model) {
        model.addAttribute("user", new Client());
        return "newUser";
    }

    @PostMapping(path = "/new")
    public String addUser(@ModelAttribute("user") Client client) {
        client.setAdmin(false);
        clientService.addUser(client);
        return "redirect:/users";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        clientService.deleteUser(id);
        return "redirect:/users";
    }
}
