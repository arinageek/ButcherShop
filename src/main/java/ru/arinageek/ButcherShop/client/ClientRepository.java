package ru.arinageek.ButcherShop.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("FROM Client WHERE email = ?1")
    Client getClientByEmail(String email);
}
