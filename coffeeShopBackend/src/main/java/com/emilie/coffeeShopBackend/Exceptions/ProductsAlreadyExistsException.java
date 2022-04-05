package com.emilie.coffeeShopBackend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductsAlreadyExistsException extends RuntimeException{
    public ProductsAlreadyExistsException(String message) { super (message); }
}
