package com.Encrypt.Encode;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class KeyGen {
    public static String generate() {
        SecureRandom random = new SecureRandom();
        byte[] joined = new byte[64];
        byte[] initial = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126};
        for (int i = 0; i < 64; i++) {
            int rnd = random.nextInt(initial.length);
            joined[i] = initial[rnd];

        }
        return new String(joined , StandardCharsets.US_ASCII);
    }
}