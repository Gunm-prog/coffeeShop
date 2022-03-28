package com.emilie.coffeeShop.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "MenuItems Not Found")
public class ProductsNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductsNotFoundException(String errorMessage){
        super (errorMessage);
    }
}
