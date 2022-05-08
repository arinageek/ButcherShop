package ru.arinageek.ButcherShop.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("FROM Cart WHERE ownerId = ?1")
    Cart getCartByOwnerId(Long id);
}