package com.example.ecomm.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private String productDescription;

    private Double price;

    // Getters and setters for the new field
    // New field for storing the image as binary data
    @Getter
    @Setter
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] productImage;
    @ManyToMany(mappedBy = "products")
    private List<Basket> baskets = new ArrayList<>();
}
