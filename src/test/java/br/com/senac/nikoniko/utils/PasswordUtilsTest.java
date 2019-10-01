package br.com.senac.nikoniko.utils;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

public class PasswordUtilsTest {

    private static final String PASSWORD = "123456";
    private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

    @Test
    public void testNullPassword() throws Exception {
        assertNull(PasswordUtils.generateBCrypt(null));
    }

    @Test
    public void testGeneratePasswordHash() throws Exception {
        String hash = PasswordUtils.generateBCrypt(PASSWORD);

        assertTrue(bCryptEncoder.matches(PASSWORD, hash));
    }

}

