package oi.github.pedroMartinsMJ.librayapi2.Repository;

import oi.github.pedroMartinsMJ.librayapi2.entities.Order;
import oi.github.pedroMartinsMJ.librayapi2.entities.Product;
import oi.github.pedroMartinsMJ.librayapi2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Order findByClient(User client);
    List<Order> findAllByClient(User client);
}
