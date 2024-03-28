package fr.sup.galilee.pharmacy.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartDto {
    private Long productId;
    private Long userId;
}
