package at.redlinghaus.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int role_id;

    @Column(name = "name")
    private String name;

    /*@ManyToMany(targetEntity = User.class, mappedBy = "roles")
    private Set<User> users;*/
}