package com.epam.basket.service;

public class NoSuchElementsException extends Exception{

    public NoSuchElementsException() {}

    public NoSuchElementsException(Exception e) {
        super(e);
    }

    public NoSuchElementsException(String message, Exception e) {
        super(message, e);
    }

    public NoSuchElementsException(String message) {
        super(message);
    }

}
