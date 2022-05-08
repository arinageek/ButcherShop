package ru.arinageek.ButcherShop.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arinageek.ButcherShop.client.Client;
import ru.arinageek.ButcherShop.client.ClientRepository;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository, ClientRepository clientRepository) {
        this.sessionRepository = sessionRepository;
        this.clientRepository = clientRepository;
    }

    public Client getCurrentUser() {
        Long currentUserId = sessionRepository.findById(SESSION_ID).get().getCurrentUserId();
        Client currentUser = clientRepository.getById(currentUserId);
        return currentUser;
    }

    public void logInWithUserId(Long id) {
        Session session = sessionRepository.findById(SESSION_ID).get();
        session.setCurrentUserId(id);
        sessionRepository.save(session);
    }

    public static final Long ADMIN_ID = 1L;
    public static final Long SESSION_ID = 1L;
}