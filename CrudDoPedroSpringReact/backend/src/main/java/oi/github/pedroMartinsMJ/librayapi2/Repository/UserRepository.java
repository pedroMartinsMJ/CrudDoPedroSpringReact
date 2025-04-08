package oi.github.pedroMartinsMJ.librayapi2.Repository;

import oi.github.pedroMartinsMJ.librayapi2.entities.Product;
import oi.github.pedroMartinsMJ.librayapi2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByNameAndPassword(String name, String password);
}
