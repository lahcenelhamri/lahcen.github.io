package com.example.ecomm.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;

    // New attributes added
    @Column(nullable = false) // Assuming age is mandatory
    @Digits(fraction = 0, integer = 3, message = "Age must be a positive integer.") // Validate age
    private Integer age;

    @Column(nullable = false) // Assuming job title is mandatory
    private String jobTitle;

    @Column(unique = true, nullable = false) // Assuming phone numbers are unique and mandatory
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Basket> baskets = new ArrayList<>();
    public User(String userId) {
        try {
            this.userId = Long.parseLong(userId); // Assuming userId is a numeric string
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric ID format", e);
        }
    }
    // Constructor, getters, and setters omitted for brevity
}
