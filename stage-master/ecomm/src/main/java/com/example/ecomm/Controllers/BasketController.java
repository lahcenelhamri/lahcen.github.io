package com.example.ecomm.Controllers;

import com.example.ecomm.Models.Basket;
import com.example.ecomm.Service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping
    public List<Basket> getAllBaskets() {
        return basketService.getAllBaskets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable Long id) {
        Optional<Basket> basket = basketService.getBasketById(id);
        if (basket.isPresent()) {
            return ResponseEntity.ok(basket.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Basket createBasket(@RequestBody Basket basket) {
        return basketService.createBasket(basket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable Long id, @RequestBody Basket basketDetails) {
        try {
            Basket updatedBasket = basketService.updateBasket(id, basketDetails);
            return ResponseEntity.ok(updatedBasket);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasket(@PathVariable Long id) {
        try {
            basketService.deleteBasket(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}