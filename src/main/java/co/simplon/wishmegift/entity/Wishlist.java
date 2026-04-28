package co.simplon.wishmegift.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "wishlists") 
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Column(length = 1000) 
    private String description;

    private LocalDate dateCreation;

    @Column(nullable = false)
    private String author;

    public Wishlist(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String auteur) {
        this.author = author;
    }
}

