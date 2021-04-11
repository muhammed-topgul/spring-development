package com.muhammedtopgul.petclinic;

/*
 * created by Muhammed Topgul
 * on 11/04/2021
 * at 19:21
 */

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

    @Test
    public void generateEncodePasswords() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("{bcrypt}" + encoder.encode("secret"));
        System.out.println("{bcrypt}" + encoder.encode("secret"));
        System.out.println("{bcrypt}" + encoder.encode("secret"));
    }
}
