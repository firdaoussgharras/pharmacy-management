package fr.sup.galilee.pharmacy.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class BillDto {
    private Long id;
    private BigDecimal montantTotal;
    private Date dateCreation;
}