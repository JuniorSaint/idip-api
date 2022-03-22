package com.idip.idiptecnologia.exceptions;

public class PasswordInvalidException extends RuntimeException{
public PasswordInvalidException(){
    super("Password doesn't match");
}
}
