package oi.github.pedroMartinsMJ.librayapi2.service;

import oi.github.pedroMartinsMJ.librayapi2.Repository.OrderRepository;
import oi.github.pedroMartinsMJ.librayapi2.Repository.UserRepository;
import oi.github.pedroMartinsMJ.librayapi2.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository
            ;

    @Autowired
    private UserRepository userRepository;

    public List<Order> findAll() {
        return orderRepository
                .findAll();
    }

    public Order findById(UUID id) {
        return orderRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Order save(Order order) {
        return orderRepository
                .save(order);
    }

    public void delete(UUID id) {
        orderRepository
                .deleteById(id);
    }

    public Order obterOrderPeloUser(String name, String password){
        return orderRepository.findByClient(userRepository.findByNameAndPassword(name, password));
    }

    public List<Order> obterOrdersPeloUser(String name, String password){
        return orderRepository.findAllByClient(userRepository.findByNameAndPassword(name, password));
    }
}
