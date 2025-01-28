package dev.dhiraj.productservicef.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel implements Serializable {
    private String title;
    private String description;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private String image;
    private int quantity;
}
