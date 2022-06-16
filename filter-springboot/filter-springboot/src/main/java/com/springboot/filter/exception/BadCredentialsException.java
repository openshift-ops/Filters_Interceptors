package com.springboot.filter.exception;

public class BadCredentialsException extends RuntimeException{

String msg;

public BadCredentialsException(String msg)
{
    super(msg);
    this.msg = msg;
}


}
