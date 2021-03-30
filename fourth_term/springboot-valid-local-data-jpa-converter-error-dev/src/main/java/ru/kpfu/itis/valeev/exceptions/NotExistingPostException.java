package ru.kpfu.itis.valeev.exceptions;

public class NotExistingPostException extends RuntimeException{
    public NotExistingPostException(String errorMessage, Throwable ex) {
        super(errorMessage, ex);
    }
}
