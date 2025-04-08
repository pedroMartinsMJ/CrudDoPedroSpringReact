package oi.github.pedroMartinsMJ.librayapi2.Repository;

import oi.github.pedroMartinsMJ.librayapi2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
