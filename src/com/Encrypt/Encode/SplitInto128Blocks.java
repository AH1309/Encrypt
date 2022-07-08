package com.Encrypt.Encode;


import org.jetbrains.annotations.NotNull;
import java.lang.Byte;
import java.util.ArrayList;


public class SplitInto128Blocks {
    public static ArrayList<ArrayList<Byte>> Split128(ArrayList<Byte> args) {

        if (args == null) {
            return null;

        }

        args = length128(args);

        ArrayList<ArrayList<Byte>> returnlist = new ArrayList<ArrayList<Byte>>();


        for (int i = 0; i <= (int) Math.ceil((float) args.size() / 16) - 1; i++) {

            ArrayList<Byte> newlist= new ArrayList<>(args.subList((0 + (16 * i)), (16 + (16 * i))));

            returnlist.add(newlist);

        }
        return returnlist;


    }
    public static ArrayList<Byte> length128(@NotNull ArrayList<Byte> args) {

        while (args.size() % 16 != 0) {
            args.add(args.size(), (byte) 32);

        }
        return args;
    }

    public static @NotNull ArrayList<Byte> join(@NotNull ArrayList<ArrayList<Byte>> args){
        ArrayList<Byte> returnlist = new ArrayList<Byte>();


        for( int i = 0 ; i < args.size(); i++ ){
            for ( int ie = 0 ; ie < args.get(i).size() ; ie++){
                returnlist.add(args.get(i).get(ie));


            }

        }
        return returnlist;
    }


}