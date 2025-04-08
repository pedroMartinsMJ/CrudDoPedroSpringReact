package oi.github.pedroMartinsMJ.librayapi2.resources;

import oi.github.pedroMartinsMJ.librayapi2.entities.Order;
import oi.github.pedroMartinsMJ.librayapi2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.ok(service.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-client")
    public ResponseEntity<Order> obiterClienteDoPedido(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "password", required = true) String password
    ){
        Order order = service.obterOrderPeloUser(name, password);

        if(order == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(order);
    }

    @GetMapping("/byAll-client")
    public ResponseEntity<List<Order>> obiterClienteDoPedidos(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "password", required = true) String password
    ){
        List<Order> order = service.obterOrdersPeloUser(name, password);

        if(order == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(order);
    }

}
