package com.Encrypt.Encode;


import java.lang.Byte;
import java.util.ArrayList;


public class SplitInto128Blocks {
    public static ArrayList<ArrayList<Byte>> Split128(ArrayList<Byte> args) {

        if (args == null) {
            return null;

        }

        args = length128(args);

        ArrayList<ArrayList<Byte>> returnlist = new ArrayList<ArrayList<Byte>>();


        for (int i = 0; i <= (int) Math.ceil((float) args.size() / 128) - 1; i++) {

            ArrayList<Byte> newlist= new ArrayList<Byte>(args.subList((0 + (128 * i)), (127 + (128 * i))));

            returnlist.add(newlist);
            
        }
        return returnlist;


    }
    public static ArrayList<Byte> length128(ArrayList<Byte> args) {

        while (args.size() % 128 != 0) {
            args.add(args.size(), (byte) 0);

        }
        return args;
    }


}
