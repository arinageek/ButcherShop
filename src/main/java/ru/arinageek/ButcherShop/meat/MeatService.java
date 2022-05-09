package ru.arinageek.ButcherShop.meat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class MeatService {

    private final MeatRepository meatRepository;

    @Autowired
    public MeatService(MeatRepository meatRepository) {
        this.meatRepository = meatRepository;
    }


    public List<Meat> getAllMeat() {
        return meatRepository.findAll();
    }

    public Meat getMeatById(Long id) { return meatRepository.getById(id); }

    public void addMeat(Meat meat) {
        meatRepository.save(meat);
    }

    public void deleteMeat(Long id) {
        boolean exists = meatRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Meat with id " + id + " doesn't exist");
        }
        meatRepository.deleteById(id);
    }

    public List<Meat> getMeatWithPriceLessThen(Double price) {
        return meatRepository.getMeatWithPriceLessThen(price);
    }
}
