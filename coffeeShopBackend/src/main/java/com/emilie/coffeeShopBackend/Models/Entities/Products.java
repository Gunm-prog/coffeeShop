package com.emilie.coffeeShopBackend.Models.Entities;

import com.emilie.coffeeShopBackend.util.CategoryEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Products implements Serializable {

    public static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_price", nullable = false)
    private double itemPrice;

    @Column(name = "item_quantity", nullable = false)
    private int itemQuantity;

    @ManyToOne
    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 20, nullable = false)
    public CategoryEnum categoryEnum;

    @ManyToOne
    @JoinColumn(name = "id")
    private Category category;

    @ManyToOne
    @JoinColumn (name = "id")
    private ShoppingCart shoppingCart;

    private boolean isAvailable;


}
