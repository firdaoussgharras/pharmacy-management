package fr.sup.galilee.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.sup.galilee.pharmacy.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}