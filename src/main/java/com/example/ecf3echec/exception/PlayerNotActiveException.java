package com.example.ecf3echec.exception;

public class PlayerNotActiveException extends RuntimeException{
    public PlayerNotActiveException(String message){
        super(message);
    }
}
