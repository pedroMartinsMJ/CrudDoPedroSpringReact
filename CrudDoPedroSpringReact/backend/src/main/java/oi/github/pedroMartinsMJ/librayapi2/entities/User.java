package oi.github.pedroMartinsMJ.librayapi2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L ;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String password;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "client")
    @JsonIgnore// para não estora a memoria
    private List<Order> orders = new ArrayList<>();

    User(){
    }

    public User(UUID id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
