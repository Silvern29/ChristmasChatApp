package at.redlinghaus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Role> roles;

    @JsonBackReference(value = "user-message")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = Message.class)
    @Column(name = "messages")
    private List<Message> messages;

    @Column(name = "last_login")
    @UpdateTimestamp
    private LocalDateTime lastLogin;

    @Column(name = "creation")
    @CreationTimestamp
    @NotNull
    private LocalDateTime creation;
}
