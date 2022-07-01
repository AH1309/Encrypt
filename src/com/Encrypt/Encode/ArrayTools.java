package com.Encrypt.Encode;

import java.util.ArrayList;

public class ArrayTools {
    public static ArrayList<Byte> ArraytoArraylist(byte[] args)  {
        ArrayList<Byte> returnlist = new ArrayList<Byte>();
        for (int i = 0 ; i < args.length ; i++) {
            returnlist.add(args[i]);


        }
        return returnlist;
    }
    public static byte[] ArraylistToarray(ArrayList<Byte> args)  {
        byte[] returnlist = new byte[ args.size()];
        for (int i = 0 ; i <= args.size(); i++) {
            returnlist[i] = args.get(i);


        }
        return returnlist;
    }
    public static ArrayList<Byte> rightRotate(ArrayList<Byte> args){
        ArrayList<Byte> ReturnList = new ArrayList<>();
        ReturnList.add(args.get(args.size()-1));
        for(int i = 1 ; i < args.size() ; i++ ){
            ReturnList.add(args.get(i));

        }
        return ReturnList;


    }


    public static ArrayList<Byte> leftRotate(ArrayList<Byte> args){
        ArrayList<Byte> ReturnList = new ArrayList<>();
        for(int i = 1 ; i < args.size() - 1 ; i++){
            ReturnList.add(args.get(i));
        }
        ReturnList.add(args.get(0));
        return ReturnList;

    }
}
