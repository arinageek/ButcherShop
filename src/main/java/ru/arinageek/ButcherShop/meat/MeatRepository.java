package ru.arinageek.ButcherShop.meat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeatRepository
        extends JpaRepository<Meat, Long> {
}
