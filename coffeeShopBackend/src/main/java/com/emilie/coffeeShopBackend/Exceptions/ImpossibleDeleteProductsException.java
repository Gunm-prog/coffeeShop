package com.emilie.coffeeShopBackend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Impossible delete product")
public class ImpossibleDeleteProductsException extends RuntimeException {
    private static final long serialVersionUID=1L;

    public ImpossibleDeleteProductsException(String errorMessage) {
        super( errorMessage );
    }

}
