package ru.arinageek.ButcherShop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arinageek.ButcherShop.cart.Cart;
import ru.arinageek.ButcherShop.cart.CartRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final CartRepository cartRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, CartRepository cartRepository) {
        this.clientRepository = clientRepository;
        this.cartRepository = cartRepository;
    }


    public List<Client> getAllUsers() {
        return clientRepository.findAll();
    }

    public Client getUserById(Long id) { return clientRepository.getById(id); }

    public void addUser(Client client) {
        clientRepository.save(client);

        Cart cart = new Cart();
        cart.setOwnerId(client.getId());
        cartRepository.save(cart);
    }

    public void deleteUser(Long id) {
        boolean exists = clientRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " doesn't exist");
        }
        clientRepository.deleteById(id);
    }

    public Client getUserByEmail(String email) {
        return clientRepository.getClientByEmail(email);
    }
}
