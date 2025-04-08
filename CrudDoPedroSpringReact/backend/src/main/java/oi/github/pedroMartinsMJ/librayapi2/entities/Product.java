package oi.github.pedroMartinsMJ.librayapi2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L ;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String name;

    @Column(name = "price", length = 200, nullable = false)
    private Double price;

    @Column(name = "stock", length = 100, nullable = false)
    private Integer stockQuantity;

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> item = new HashSet<>();

    public Product(){
    }
    public Product(String name, Double price, Integer stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }


}
