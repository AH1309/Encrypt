package com.Encrypt;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Scanner;

public class Main {
    private static byte[] strictStringToBytes(String s, Charset charset) throws CharacterCodingException {
        ByteBuffer x  = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s));
        byte[] b = new byte[x.remaining()];
        x.get(b);
        return b;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Encrypt or Decrypt");
        String Line = input.nextLine();
        if (Line == "Encrypt"){

        } else if (Line == "Decrypt") {
            System.out.println("Enter Private Key(ASCII CharDet): ");
            String Key = input.nextLine();
            System.out.println("Enter Data: ");
            String Data = input.nextLine();
        }


    }

}

