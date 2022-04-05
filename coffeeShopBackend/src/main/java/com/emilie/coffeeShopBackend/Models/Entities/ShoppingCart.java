package com.emilie.coffeeShopBackend.Models.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name= "added_to_cart")
@Data
@Getter
@Setter
@NoArgsConstructor
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    //TODO check sens relation
    @OneToMany
    @JoinColumn(name = "products_id")
    private Products products;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column (name = "creation_date")
    LocalDateTime creationDate;





}
