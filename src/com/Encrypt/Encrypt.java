package com.Encrypt;

import java.security.NoSuchAlgorithmException;

public class Encrypt {
    // begin by generating private key
    public static byte[] EncryptAlgorithm(byte[] args) {
        String Key;

        {
            try {
                Key = com.Encrypt.Encode.keyGen.generateAESKey().getFormat();
            } catch (NoSuchAlgorithmException e) {

            }

        }

        // calls tablehash function
    }
}
