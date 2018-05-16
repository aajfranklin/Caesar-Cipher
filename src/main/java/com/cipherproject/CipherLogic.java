package com.cipherproject;

/**
 * Class implementing Caesar cipher encryption and decryption algorithms
 * Does not support encryption of non-alphabetic characters
 * @author Alex Franklin
 */
public class CipherLogic {

    /**
     * Encrypts a message with a monoalphabetic substitution specified by a key value
     * @param plaintext String - the message to be encrypted
     * @param key int - the encryption key
     * @return String - the ciphertext
     */
    public String encrypt(String plaintext, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Unify case of user input
        plaintext = plaintext.toUpperCase();

        StringBuilder ciphertext = new StringBuilder();
        int[] plaintextAsInteger = new int[plaintext.length()];

        // Convert each element of the plaintext to an integer from 0-25
        // Increase the integer value for each element according to the key
        // Reconvert the integer value to the appropriate character and add to the ciphertext
        for (int i = 0; i < plaintext.length(); i++) {
            plaintextAsInteger[i] = (alphabet.indexOf(plaintext.charAt(i)) + key) % 26;
            ciphertext.append(alphabet.charAt(plaintextAsInteger[i]));
        }

        return ciphertext.toString();
    }

    /**
     * Decrypts a message with a monoalphabetic substitution specified by a key value
     * @param ciphertext String - the message to decrypt
     * @param key int - the encryption key
     * @return String - the plaintext
     */
    public String decrypt(String ciphertext, int key) {

        // Invert key
        key = 26 - (key % 26);

        return this.encrypt(ciphertext, key);
    }
}