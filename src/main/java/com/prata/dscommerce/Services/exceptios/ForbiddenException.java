package com.prata.dscommerce.Services.exceptios;

public class ForbiddenException extends RuntimeException
{
    public ForbiddenException(String message) {

        super(message);
    }
}
