package ru.arinageek.ButcherShop.session;

import javax.persistence.*;

import static ru.arinageek.ButcherShop.session.SessionService.ADMIN_ID;
import static ru.arinageek.ButcherShop.session.SessionService.SESSION_ID;

@Entity
@Table
public class Session {

    @Id
    private Long id = SESSION_ID;

    private Long currentUserId = ADMIN_ID;

    public Session() {}

    public Session(Long currentUserId) {
        this.currentUserId = currentUserId;
    }

    public Long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Long currentUserId) {
        this.currentUserId = currentUserId;
    }

    public Long getId() { return id; }
}
