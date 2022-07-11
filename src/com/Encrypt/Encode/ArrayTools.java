package com.Encrypt.Encode;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTools extends Tools {
    public static ArrayList<Byte> ArraytoArraylist(byte[] args)  {
        ArrayList<Byte> returnlist = new ArrayList<Byte>();
        for (int i = 0 ; i < args.length ; i++) {
            returnlist.add(args[i]);


        }
        return returnlist;
    }
    public static byte[] ArraylistToarray(ArrayList<Byte> args)  {
        byte[] returnlist = new byte[ args.size()];
        for (int i = 0 ; i < args.size(); i++) {
            returnlist[i] = args.get(i);


        }
        return returnlist;
    }
    public static ArrayList<Byte> rightRotate(ArrayList<Byte> args) {
        ArrayList<Byte> ReturnList = new ArrayList<>();
        ReturnList.add(args.get(args.size() - 1));
        for (int i = 0; i < args.size() - 1; i++) {
            ReturnList.add(args.get(i));

        }

        return ReturnList;

    }
    public static ArrayList<Byte> leftRotate(ArrayList<Byte> args) {
        System.out.println(args.size());
        ArrayList<Byte> ReturnList = new ArrayList<>();

        for (int i = 1; i < args.size(); i++) {
            ReturnList.add(args.get(i));
        }
        ReturnList.add(args.get(0));
        return ReturnList;
    }
    public static ArrayList<ArrayList<Byte>> listRightRotate(ArrayList<ArrayList<Byte>> args){
        for(int i = 0 ; i < args.size() ; i++){
            ArrayList<Byte> data = args.get(i);
            args.set(i , rightRotate(data));
        }
        return args;
    }
    public static ArrayList<ArrayList<Byte>> listLeftRotate(ArrayList<ArrayList<Byte>> args){
        for(int i = 0 ; i < args.size() ; i++){
            ArrayList<Byte> data = args.get(i);
            args.set(i , leftRotate(data));
        }
        return args;
    }
    public static ArrayList<Byte> BitwiseXOR( ArrayList<Byte> args , ArrayList<Byte> key) {
        for (int i = 0; i < args.size(); i++) {

                args.set(i,(byte) (args.get(i) ^ key.get(i % 64)));
        }
        return args;
    }
    public static byte[] ObjectToByte(Object[] args )
        throws Exception{
        byte[] ReturnArray = new byte[args.length];

        for( int i = 0; i < args.length ; i++){
            ReturnArray[i] = (byte) args[i];
        }
        return ReturnArray;
    }
    public static byte[] StringToArrayList( String args)
            throws Exception {
        args = args.substring(1);
        args = args.substring(0,args.length()-1);
        Object[] Input = Arrays.stream(args.split(", ")).map(Byte::valueOf).toArray();
        byte[] Returnlist = ObjectToByte(Input);
        return Returnlist;

    }


}

