package com.emilie.coffeeShopBackend.Models.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    private String roles;
    private AddressDto addressDto = null;

}
