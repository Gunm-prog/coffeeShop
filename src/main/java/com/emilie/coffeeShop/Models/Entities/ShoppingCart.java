package com.emilie.coffeeShop.Models.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name= "added_to_cart")
@Data
@NoArgsConstructor
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    //TODO check sens relation
    @OneToMany
    @JoinColumn(name = "menu_items_id")
    private Products products;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column (name = "creation_date")
    LocalDateTime creationDate;





}
