package ru.arinageek.ButcherShop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.arinageek.ButcherShop.session.SessionService;

@Controller
@RequestMapping("/users")
public class ClientController {

    private final ClientService clientService;
    private final SessionService sessionService;

    @Autowired
    public ClientController(ClientService clientService, SessionService sessionService) {
        this.clientService = clientService;
        this.sessionService = sessionService;
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
        clientService.addUser(client);
        return "redirect:/";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        clientService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(path = "/login")
    public String logIn(Model model) {
        model.addAttribute("info", new LogInInfo());
        return "logIn";
    }

    @PostMapping(path = "/login")
    public String logIn(@ModelAttribute("email") LogInInfo info) {
        Client client = clientService.getUserByEmail(info.getEmail());
        if (client != null) {
            sessionService.logInWithUserId(client.getId());
        }
        return "redirect:/";
    }

}
