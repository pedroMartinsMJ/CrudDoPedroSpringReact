package oi.github.pedroMartinsMJ.librayapi2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import oi.github.pedroMartinsMJ.librayapi2.entities.pk.OrderItemPK;



import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_Order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L ;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem() {}

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    // Para facilitar acesso direto ao Order e Product:
    @JsonIgnore
    public UUID getOrderId() {
        return id.getOrder().getId();
    }

    public UUID getProductId() {
        return id.getProduct().getId();
    }
}

