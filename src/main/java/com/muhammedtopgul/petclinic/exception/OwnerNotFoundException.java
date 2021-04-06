package com.muhammedtopgul.petclinic.exception;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:51
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
