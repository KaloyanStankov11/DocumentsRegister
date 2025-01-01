package com.example.documentsregister.exceptions;

public class InvalidNameException extends Exception{
    public InvalidNameException() {
        super("Invalid name! Name must be between 3 and 48 symbols long");
    }
}
