package com.muhammedtopgul.petclinic.exception;

/*
 * created by Muhammed Topgul
 * on 07/04/2021
 * at 00:34
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {
}
