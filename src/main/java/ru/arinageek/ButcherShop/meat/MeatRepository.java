package ru.arinageek.ButcherShop.meat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeatRepository
        extends JpaRepository<Meat, Long> {

    @Query("FROM Meat WHERE price < ?1")
    List<Meat> getMeatWithPriceLessThen(Double price);
}
