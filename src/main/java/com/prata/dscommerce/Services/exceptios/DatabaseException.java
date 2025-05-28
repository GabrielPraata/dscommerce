package com.prata.dscommerce.Services.exceptios;

public class DatabaseException extends RuntimeException
{
    public DatabaseException(String message) {

        super(message);
    }
}
