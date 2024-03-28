package fr.sup.galilee.pharmacy.mappers;

import fr.sup.galilee.pharmacy.dtos.BillDto;
import fr.sup.galilee.pharmacy.entities.Bill;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FactureMapper {
    public BillDto toDto(Bill bill) {
        return BillDto.builder()
                .id(bill.getId())
                .montantTotal(BigDecimal.valueOf(bill.getTotal()))
                .dateCreation(bill.getDate())
                .build();
    }

    public Bill toEntity(BillDto billDto) {
        Bill bill = new Bill();
        bill.setId(billDto.getId());
        bill.setTotal(billDto.getMontantTotal().floatValue());
        bill.setDate(billDto.getDateCreation());
        return bill;
    }
}