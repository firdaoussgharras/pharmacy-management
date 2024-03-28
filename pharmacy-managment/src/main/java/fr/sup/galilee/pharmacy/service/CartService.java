package fr.sup.galilee.pharmacy.service;

import fr.sup.galilee.pharmacy.entities.Cart;
import fr.sup.galilee.pharmacy.entities.Product;
import fr.sup.galilee.pharmacy.entities.ProductCart;
import fr.sup.galilee.pharmacy.entities.User;
import fr.sup.galilee.pharmacy.repositories.CartRepository;
import fr.sup.galilee.pharmacy.repositories.ProductCartRepository;
import fr.sup.galilee.pharmacy.repositories.ProductRepository;
import fr.sup.galilee.pharmacy.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductCartRepository productCartRepository;



    private List<Product> panier;

    public CartService() {
        panier = new ArrayList<>();
    }

    public void addToCart(Long userId, Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                Optional<Cart> cartOptional = cartRepository.findByUserId(userId);
                if (cartOptional.isPresent()) {
                    Cart cart = cartOptional.get();
                    Optional<ProductCart> productCartOptional = productCartRepository.findByCartIdAndProductId(cart.getId(), productId);
                    if (productCartOptional.isPresent()){
                        ProductCart productCart = productCartOptional.get();
                        productCart.setQuantity(productCart.getQuantity() + 1);
                        productCartRepository.save(productCart);
                    } else {
                        ProductCart productCart =  ProductCart.builder()
                                .product(product)
                                .cart(cart)
                                .quantity(1).build();

                        productCartRepository.save(productCart);
                    }
                } else {
                    Cart cart = Cart.builder().user(user).build();
                    Cart savedCart = cartRepository.save(cart);
                    ProductCart productCart =  ProductCart.builder()
                            .product(product)
                            .cart(savedCart)
                            .quantity(1).build();
                    productCartRepository.save(productCart);
                }
            } else {
                throw new EntityNotFoundException("Le produit avec l'ID " + productId + " n'existe pas.");
            }
        } else {
            throw new EntityNotFoundException("Le médicament avec l'ID " + userId + " n'existe pas.");
        }
    }

    public void removeFromPanier(Long id) {
        Optional<Product> produitOptional = panier.stream()
                .filter(produit -> produit.getId().equals(id))
                .findFirst();
        if (produitOptional.isPresent()) {
            panier.remove(produitOptional.get());
        } else {
            throw new EntityNotFoundException("Le produit avec l'ID " + id + " n'existe pas dans le panier.");
        }
    }

    public List<Product> getPanier() {
        return panier;
    }
}
