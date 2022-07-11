package com.Encrypt;

import com.Encrypt.Encode.*;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    private static byte[] strictStringToBytes(String s, Charset charset) throws CharacterCodingException {
        ByteBuffer x = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s));
        byte[] b = new byte[x.remaining()];
        x.get(b);
        return b;
    }

    public static void main(String[] args)
            throws Exception {
        String Key = KeyGen.generate();
        String Hello = "This Is Correct !";
        for (int i = 3; i >= 0; i--) {
            Hello = Execute.Encrypt2(Key, Hello);
        }
        System.out.println(Hello);
        for (int i = 3; i >= 0; i--) {
            Hello = Decode.Decode2(Key, Hello);

        }
        System.out.println(Hello);
        Scanner input = new Scanner(System.in);

        System.out.println("Hello Do you Want To Encrypt Or Decrypt ??");
        String Mode  = input.nextLine();
        System.out.println(Mode);


        if (Objects.equals(Mode, "Encrypt")){
            System.out.println("Enter Data");

            String key = KeyGen.generate();
            String Data = input.nextLine();

            System.out.println(Execute.Encrypt(key , Data));
            System.out.println(key);

        }
        else if (Objects.equals(Mode , "Decrypt")){
            System.out.println("Bytes Or String?");
            String mode = input.nextLine();
            System.out.println("Enter Data");
            String Data = input.nextLine();
            System.out.println("Key");
            String Keyy = input.nextLine();

            if(Objects.equals(mode, "Bytes")){
                byte[] data = ArrayTools.StringToArrayList(Data);
                Data = new String(data,StandardCharsets.US_ASCII);

            }

            System.out.println(Decode.FullDecode(Keyy,Data));

        }


    }
}



