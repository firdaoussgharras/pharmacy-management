package fr.sup.galilee.pharmacy.mappers;

import fr.sup.galilee.pharmacy.dtos.ProductDto;
import fr.sup.galilee.pharmacy.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProduitMapper {

    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice((float) productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        return product;
    }
}
