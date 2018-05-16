package com.cipherproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Caesar cipher logic test class
 * @author Alex Franklin
 */
public class CipherLogicTest {

    private CipherLogic testLogic;

    @Before
    public void setUp() {
        testLogic = new CipherLogic();
    }

    @Test
    public void encrypt() {
        String plaintext = "abcdefghijklmnopqrstuvwxyz";
        String ciphertext = "DEFGHIJKLMNOPQRSTUVWXYZABC";
        int key = 3;
        assertEquals(ciphertext, testLogic.encrypt(plaintext, key));
    }

    @Test
    public void decrypt() {
        String ciphertext = "DEFGHIJKLMNOPQRSTUVWXYZABC";
        String plaintext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int key = 3;
        assertEquals(plaintext, testLogic.decrypt(ciphertext, key));
    }

    @Test
    public void largeKeyEncrypt() {
        String plaintext = "abcdefghijklmnopqrstuvwxyz";
        String ciphertext = "DEFGHIJKLMNOPQRSTUVWXYZABC";
        int key = 29;
        assertEquals(ciphertext, testLogic.encrypt(plaintext, key));
    }

    @Test
    public void largeKeyDecrypt() {
        String ciphertext = "DEFGHIJKLMNOPQRSTUVWXYZABC";
        String plaintext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int key = 29;
        assertEquals(plaintext, testLogic.decrypt(ciphertext, key));
    }
}