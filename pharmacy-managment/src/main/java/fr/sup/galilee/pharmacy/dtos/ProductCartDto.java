package fr.sup.galilee.pharmacy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCartDto {
    private Long id;
    private Long panierId;
    private Long produitId;
}
