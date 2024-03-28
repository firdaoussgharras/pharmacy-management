package fr.sup.galilee.pharmacy.repositories;

import fr.sup.galilee.pharmacy.entities.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    Optional<ProductCart> findByCartIdAndProductId(Long cartId, Long ProductId);
}
