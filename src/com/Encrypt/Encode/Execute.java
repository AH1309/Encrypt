package com.Encrypt.Encode;


import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;




public class Execute {
    public static byte[] strictStringToBytes(String s, Charset charset) throws CharacterCodingException {
        ByteBuffer x  = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s));
        byte[] b = new byte[x.remaining()];
        x.get(b);
        return b;
    }
    public static String Encrypt(String key , String data) throws CharacterCodingException{
        byte[] datatobyte = strictStringToBytes(data, Charset.forName("US-ASCII"));
        ArrayList<Byte> nearlyfinished = ArraytoArraylist(datatobyte);
        ArrayList<ArrayList<Byte>> finished = SplitInto128Blocks.Split128(nearlyfinished);
        
        
        // tablehash function and replacement

        // right rotates

        // deconversion


        





        return encryptedthing;
    }

    public static byte[] ArraylistToarray(ArrayList<Byte> args)  {
        byte[] returnlist = new byte[ args.size()];
        for (int i = 0 ; i < args.size(); i++) {
            returnlist[i] = args.get(i);


        }
        return returnlist;
    }
    public static ArrayList<Byte> ArraytoArraylist(byte[] args)  {
        ArrayList<Byte> returnlist = new ArrayList<Byte>();
        for (int i = 0 ; i < args.length ; i++) {
            returnlist.add(args[i]);


        }
        return returnlist;
    }
}
