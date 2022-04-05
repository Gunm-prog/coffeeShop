package com.emilie.coffeeShopBackend.Models.Entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    private static final long seriaVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;



    @Column(name = "roles", nullable = false)
    private String roles;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn (name = "cart_id", nullable = false)
    private ShoppingCart shoppingCart;
}
