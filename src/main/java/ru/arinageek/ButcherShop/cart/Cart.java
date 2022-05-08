package ru.arinageek.ButcherShop.cart;

import ru.arinageek.ButcherShop.meat.Meat;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Cart {

    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private Long id;
    private Long ownerId;

    @ManyToMany
    @JoinTable(
            name = "cart_contents",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "meat_id")
    )
    private Set<Meat> contents = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Set<Meat> getContents() {
        return contents;
    }

    public void setContents(Set<Meat> contents) {
        this.contents = contents;
    }

    public void addMeat(Meat meat) {
        contents.add(meat);
    }
}
