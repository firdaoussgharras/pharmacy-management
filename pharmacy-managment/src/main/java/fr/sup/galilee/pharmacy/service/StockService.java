package fr.sup.galilee.pharmacy.service;

import fr.sup.galilee.pharmacy.entities.Product;
import fr.sup.galilee.pharmacy.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduit(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            throw new EntityNotFoundException("Le médicament avec l'ID " + id + " n'existe pas dans le stock.");
        }
    }
    public void deleteProduit(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Le médicament avec l'ID " + id + " n'existe pas dans le stock.");
        }
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Le médicament avec l'ID " + id + " n'existe pas dans le stock."));
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }


}
