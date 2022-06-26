package com.Encrypt.Encode;

import java.lang.Byte;
import java.nio.ByteBuffer;
import java.util.ArrayList;



public class SplitInto128Blocks {
    public static byte[][] Split128(byte [] args){
        byte[][] returnvariable = null; //!!!! NEEDS TO BE FIXED
        if (args == null){
            return null;

        }
        ArrayList<ArrayList<Byte>> returnlist = new ArrayList<ArrayList<Byte>>();


        for(int i = 1; i <= (int) Math.ceil((float) args.length / 128) ; i++){

            ByteBuffer buffer = ByteBuffer.wrap(args);
            byte[] splited = new byte[128];
            buffer.get(splited);


        }
        return returnvariable; // NEEDS TO BE FIXED

    }
}
