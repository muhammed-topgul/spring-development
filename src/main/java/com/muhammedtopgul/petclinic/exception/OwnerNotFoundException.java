package com.muhammedtopgul.petclinic.exception;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:51
 */

public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
