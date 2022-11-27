package ru.arinageek.ButcherShop.meat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MeatRepositoryTest {

    @Autowired
    private MeatRepository underTest;

    @Test
    void getMeatWithPriceLessThen__ZeroMatches() {
        //given
        Meat meat1 = new Meat(1L, "category", "title", "description", 100.0);
        Meat meat2 = new Meat(2L, "category", "title", "description", 300.0);
        underTest.save(meat1);
        underTest.save(meat2);

        //when
        List<Meat> meats = underTest.getMeatWithPriceLessThen(50.0);

        //then
        assertEquals(0, meats.size());
    }

    @Test
    void getMeatWithPriceLessThen__OneMatch() {
        //given
        Meat meat1 = new Meat(1L, "category", "title", "description", 100.0);
        Meat meat2 = new Meat(2L, "category", "title", "description", 300.0);
        underTest.save(meat1);
        underTest.save(meat2);

        //when
        List<Meat> meats = underTest.getMeatWithPriceLessThen(200.0);

        //then
        assertEquals(1, meats.size());
    }

    @Test
    void getMeatWithPriceLessThen__TwoMatches() {
        //given
        Meat meat1 = new Meat(1L, "category", "title", "description", 100.0);
        Meat meat2 = new Meat(2L, "category", "title", "description", 160.0);
        underTest.save(meat1);
        underTest.save(meat2);

        //when
        List<Meat> meats = underTest.getMeatWithPriceLessThen(200.0);

        //then
        assertEquals(2, meats.size());
    }

    @Test
    void getMeatMatchingQuery__ZeroMatches() {
        //given
        Meat meat1 = new Meat(1L, "category", "some text", "description", 100.0);
        Meat meat2 = new Meat(2L, "category", "title", "description", 160.0);
        underTest.save(meat1);
        underTest.save(meat2);

        //when
        List<Meat> meats = underTest.getMeatMatchingQuery("query");

        //then
        assertEquals(0, meats.size());
    }

    @Test
    void getMeatMatchingQuery__OneMatch() {
        //given
        Meat meat1 = new Meat(1L, "category", "some text", "description", 100.0);
        Meat meat2 = new Meat(2L, "category", "title", "description", 160.0);
        underTest.save(meat1);
        underTest.save(meat2);

        //when
        List<Meat> meats = underTest.getMeatMatchingQuery("some t");

        //then
        assertEquals(1, meats.size());
    }

    @Test
    void getMeatMatchingQuery__TwoMatches() {
        //given
        Meat meat1 = new Meat(1L, "category", "some text", "description", 100.0);
        Meat meat2 = new Meat(2L, "category", "some title", "description", 160.0);
        underTest.save(meat1);
        underTest.save(meat2);

        //when
        List<Meat> meats = underTest.getMeatMatchingQuery("some t");

        //then
        assertEquals(2, meats.size());
    }
}