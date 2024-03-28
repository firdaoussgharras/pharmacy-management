package fr.sup.galilee.pharmacy.service;

import fr.sup.galilee.pharmacy.entities.Bill;
import fr.sup.galilee.pharmacy.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FacturationService {
    @Autowired
    private BillRepository billRepository;

    public Bill createFacture(float total, Long userId) {
        Bill bill = new Bill();
        bill.setTotal(total);
        bill.setId_user(userId);
        bill.setDate(new Date());
        return billRepository.save(bill);
    }

    public Bill getFacture(Long factureId) {
        return billRepository.findById(factureId).orElse(null);
    }
}
