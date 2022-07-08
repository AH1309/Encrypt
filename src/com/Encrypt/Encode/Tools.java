package com.Encrypt.Encode;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

public class Tools {
    public static byte[] strictStringToBytes(String s, Charset charset) throws CharacterCodingException {
        ByteBuffer x  = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s));
        byte[] b = new byte[x.remaining()];
        x.get(b);
        return b;
    }
    public static int findIndex(byte arr[], byte t)
    {
        if (arr == null) {return -1;}
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == t) {return i;}
            else {i = i + 1;}
        }
        return -1;
    }
}
