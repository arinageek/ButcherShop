package ru.arinageek.ButcherShop.meat;

import javax.persistence.*;

@Entity
@Table
public class Meat {
    @Id
    @SequenceGenerator(
            name = "meat_sequence",
            sequenceName = "meat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meat_sequence"
    )
    private Long id;
    private String category;
    private String title;
    private String description;
    private Double price;

    public Meat() {
    }

    public Meat(Long id, String category, String title, String description, Double price) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Meat(String category, String title, String description, Double price) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
