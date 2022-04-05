package com.emilie.coffeeShopBackend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="ShoppingCart Not Found")

public class ShoppingCartNotFoundException extends RuntimeException {
    private static final long serialVersionUID=1L;

    public ShoppingCartNotFoundException(String errorMessage) { super (errorMessage); }
}
