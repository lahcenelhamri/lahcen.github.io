package com.example.ecomm.Service;

import com.example.ecomm.Models.Basket;
import com.example.ecomm.Repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    public Optional<Basket> getBasketById(Long id) {
        return basketRepository.findById(id);
    }

    public Basket createBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public Basket updateBasket(Long id, Basket basketDetails) {
        Basket basket = basketRepository.findById(id).orElseThrow(() -> new RuntimeException("Basket not found"));
        basket.setUser(basketDetails.getUser());
        basket.setProducts(basketDetails.getProducts());
        return basketRepository.save(basket);
    }

    public void deleteBasket(Long id) {
        Basket basket = basketRepository.findById(id).orElseThrow(() -> new RuntimeException("Basket not found"));
        basketRepository.delete(basket);
    }
}

