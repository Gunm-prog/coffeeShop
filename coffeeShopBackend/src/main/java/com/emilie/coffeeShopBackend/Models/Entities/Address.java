package com.emilie.coffeeShopBackend.Models.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID=1L;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;

    @Column(name = "city", nullable = false)
    private String city;
}
