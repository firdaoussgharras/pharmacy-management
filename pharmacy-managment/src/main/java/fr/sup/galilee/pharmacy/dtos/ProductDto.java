package fr.sup.galilee.pharmacy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {
    @NotNull(groups = ProduitUpdate.class)
    private Long id;

    @NotBlank(groups = {ProduitCreation.class, ProduitUpdate.class})
    private String name;

    @NotNull(groups = {ProduitCreation.class, ProduitUpdate.class})
    private float price;

    @NotNull(groups = {ProduitCreation.class, ProduitUpdate.class})
    private int quantity;



    public interface ProduitCreation{}
    public interface ProduitUpdate{}
}
