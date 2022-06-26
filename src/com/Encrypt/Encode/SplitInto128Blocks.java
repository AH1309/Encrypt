package com.Encrypt.Encode;

import java.lang.Byte;
import java.nio.ByteBuffer;
import java.util.ArrayList;



public class SplitInto128Blocks {
    public static ArrayList<ArrayList<Byte>> Split128(ArrayList<Byte> args){

        if (args == null){
            return null;

        }

        ArrayList<ArrayList<Byte>> returnlist = new ArrayList<ArrayList<Byte>>();


        for(int i = 1; i <= (int) Math.ceil((float) args.size() / 128) ; i++){

          //  ByteBuffer buffer = ByteBuffer.wrap(args); // Legacy method
           // byte[] splited = new byte[128];
          //  buffer.get(splited);


        }
        return null;
    }
        public static void lengthequalsmod128(String[] args) {
        ArrayList<Byte> data = new ArrayList<Byte>();
        data.add((byte) 12);
        while (data.size() % 128 != 0) {
            data.add(data.size(), (byte) 0);

        }
        System.out.println(data);
        System.out.println(data.size());


    }

}
