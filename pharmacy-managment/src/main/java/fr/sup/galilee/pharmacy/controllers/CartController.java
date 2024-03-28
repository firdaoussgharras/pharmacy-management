package fr.sup.galilee.pharmacy.controllers;

import fr.sup.galilee.pharmacy.dtos.CartDto;
import fr.sup.galilee.pharmacy.entities.Product;
import fr.sup.galilee.pharmacy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panier")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Void> addToCart(@RequestBody CartDto cartDto) {
        cartService.addToCart(cartDto.getUserId(), cartDto.getProductId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> removeFromPanier(@PathVariable("id") Long id) {
        cartService.removeFromPanier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getPanier() {
        List<Product> panier = cartService.getPanier();
        return new ResponseEntity<>(panier, HttpStatus.OK);
    }
    @GetMapping("/string")
    public ResponseEntity<String> getMessage() {
        String message = "Omar";
        return ResponseEntity.ok(message);
    }
}
