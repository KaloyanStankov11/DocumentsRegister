package com.example.documentsregister.exceptions;

public class InvalidTypeException extends Exception{
    public InvalidTypeException(String type) {
        super("Document type: " + type + " does not exists!");
    }
}
