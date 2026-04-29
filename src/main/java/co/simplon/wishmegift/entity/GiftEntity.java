package co.simplon.wishmegift.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// Ici "gift" sans "s"
@Table(name = "gift")
public class GiftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long giftId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 255)
    private String link;

    @Enumerated(EnumType.STRING)
    private DesireLevel desireLevel;

    @Column(nullable = false)
    private Double price;

    private Boolean available = true;

    public void Gift() {
    }

    public void Gift(String title, String description, boolean available) {
        this.name = title;
        this.description = description;
        this.available = available;
    }

    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public DesireLevel getDesireLevel() {
        return desireLevel;
    }

    public void setDesireLevel(DesireLevel desireLevel) {
        this.desireLevel = desireLevel;
    }

    // Getters / Setters
}