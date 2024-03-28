package fr.sup.galilee.pharmacy.repositories;

import fr.sup.galilee.pharmacy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
