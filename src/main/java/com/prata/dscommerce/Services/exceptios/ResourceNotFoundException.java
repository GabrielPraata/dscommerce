package com.prata.dscommerce.Services.exceptios;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message) {

        super(message);
    }
}
