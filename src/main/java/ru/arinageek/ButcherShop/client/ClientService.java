package ru.arinageek.ButcherShop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getAllUsers() {
        return clientRepository.findAll();
    }

    public Client getUserById(Long id) { return clientRepository.getById(id); }

    public void addUser(Client client) {
        clientRepository.save(client);
    }

    public void deleteUser(Long id) {
        boolean exists = clientRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " doesn't exist");
        }
        clientRepository.deleteById(id);
    }
}
