package com.example.demo.controller;

import com.example.demo.model.ShoppingCart;
import com.example.demo.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<ShoppingCart> getAllShoppingCartItems() {
        return shoppingCartService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartItemById(@PathVariable Long id) {
        return shoppingCartService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShoppingCart createShoppingCartItem(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.save(shoppingCart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateShoppingCartItem(@PathVariable Long id, @RequestBody ShoppingCart shoppingCartDetails) {
        return shoppingCartService.findById(id).map(shoppingCart -> {
            shoppingCart.setUser(shoppingCartDetails.getUser());
            shoppingCart.setProduct(shoppingCartDetails.getProduct());
            shoppingCart.setQuantity(shoppingCartDetails.getQuantity());
            ShoppingCart updatedShoppingCart = shoppingCartService.save(shoppingCart);
            return ResponseEntity.ok(updatedShoppingCart);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingCartItem(@PathVariable Long id) {
        return shoppingCartService.findById(id).map(shoppingCart -> {
            shoppingCartService.deleteById(id);
            return ResponseEntity.ok().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
