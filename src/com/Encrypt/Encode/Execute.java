package com.Encrypt.Encode;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

public class Execute {
    public static byte[] strictStringToBytes(String s, Charset charset) throws CharacterCodingException {
        ByteBuffer x  = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s));
        byte[] b = new byte[x.remaining()];
        x.get(b);
        return b;
    }
    public static String Encrypt(String key , String data) throws CharacterCodingException{
        byte[] datatobyte = strictStringToBytes(data, Charset.forName("US-ASCII"));
        byte[][] encryptingthing = SplitInto128Blocks.Split128(datatobyte);
        
        
        
        
        return encryptedthing; 
    }
}
