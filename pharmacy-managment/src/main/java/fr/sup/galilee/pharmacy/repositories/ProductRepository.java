package fr.sup.galilee.pharmacy.repositories;

import fr.sup.galilee.pharmacy.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(int id);
}
