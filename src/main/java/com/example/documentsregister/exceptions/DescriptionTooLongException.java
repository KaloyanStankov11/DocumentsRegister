package com.example.documentsregister.exceptions;

public class DescriptionTooLongException extends Exception{
    public DescriptionTooLongException() {
        super("Description must be between 3 and 512 symbols long!");
    }
}
