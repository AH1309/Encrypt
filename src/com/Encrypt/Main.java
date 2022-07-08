package com.Encrypt;

import com.Encrypt.Encode.*;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static byte[] strictStringToBytes(String s, Charset charset) throws CharacterCodingException {
        ByteBuffer x = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s));
        byte[] b = new byte[x.remaining()];
        x.get(b);
        return b;
    }

    public static void main(String[] args)
            throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Encrypt or Decrypt");
        String Line = input.nextLine();
        if (Objects.equals(Line, "Encrypt")) {
            String Key = KeyGen.generate();
            String Key2 = KeyGen.generate();
            String Key3 = KeyGen.generate();
            String Key4 = KeyGen.generate();


            String[] KeyArray = new String[]{Key, Key2, Key3, Key4};
            System.out.println("Mode String Or Bytes?");
            String Mode = input.nextLine();
            String Data = null;
            ArrayList<Byte> sdata = new ArrayList<>();

                System.out.println("Enter Data: ");
                Data = input.nextLine();
                sdata = ArrayTools.ArraytoArraylist(Tools.strictStringToBytes(Data, StandardCharsets.US_ASCII));


            for (int i = 0; i < 4; i++) {
                Data = Execute.Encrypt2(KeyArray[i], sdata);
            }

            System.out.println("Encrypted Message : " + Data);
            System.out.println("Key:" + Key + Key2 + Key3 + Key4);
            // stays legacy System.out.println(Decode.Decode2(Key3 , Execute.Encrypt2(Key3,"Hi Im Alireza From Khalo (Potato is good)!! i like biscuites biscuits biscuits hi byte      ")));

            //System.out.println(Execute.Encrypt2(Key,"eeeee"));


        } else if (Objects.equals(Line, "Decrypt")) {
            System.out.println("Enter Private Key(ASCII CharDet): ");
            String Key = input.nextLine();
            if (Key.length() != 256){
                throw new Exception("");

            }
            String Key1 = (Key.substring(0, 64));
            String Key2 = (Key.substring(64, 128));
            String Key3 = (Key.substring(128, 192));
            String Key4 = Key.substring(192, 256);
            String[] KeyArray = {Key1, Key2, Key3, Key4};


            System.out.println("Mode String Or Bytes?");
            String Mode = input.nextLine();
            String Data = null ;
            Data = input.nextLine();
            ArrayList<Byte> sdata = ArrayTools.ArraytoArraylist(Tools.strictStringToBytes(Data, StandardCharsets.US_ASCII));





                for (int i = 3; i >= 0; i--) {
                    Data = Decode.Decode2(KeyArray[i], sdata);
                }

                System.out.println(Data);
            }
        }
    }

