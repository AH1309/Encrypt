package com.Encrypt.Encode;

import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;
import java.util.ArrayList;


public class Table {
    public static byte[] GenerateReplaceTable(ArrayList<Byte> args)
            throws Exception{
        if(args.size() != 64){
            throw new Exception();
        }
        byte[] initial = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127};

        for(int i = 0 ; i < initial.length ;i++){
            int index = args.get(i%64)%initial.length;
            byte a = initial[index];
            initial[index] = initial[i];
            initial[i] = a;
        }
        return initial;
    }
    public static byte[] GenerateReplaceTable2(ArrayList<Byte> args)
            throws Exception{
        if(args.size() != 64){
            throw new Exception();
        }
        byte[] initial = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126};

        for(int i = 0 ; i < initial.length ;i++){
            int index = args.get(i%64)%initial.length;
            byte a = initial[index];
            initial[index] = initial[i];
            initial[i] = a;
        }
        return initial;
    }

    public static ArrayList<Byte> SubBytes(ArrayList<Byte> args , byte[] table){
        for(int i = 0 ; i < args.size() ; i++){args.set(i , table[args.get(i)]);}
        return args;
    }
    public static ArrayList<Byte> SubBytes2(ArrayList<Byte> args , byte[] table){
        ArrayList<Byte> Table = ArrayTools.ArraytoArraylist(table);
        for(int i = 0 ; i < args.size() ; i++){args.set(i , (byte)Table.indexOf(args.get(i)));}
        return args;
    }
    public static byte[] inverseTable(byte[] table){
        byte[] array = new byte[128];
        for(int i = 0 ; i < table.length ; i++){
            array[i] = (byte) Tools.findIndex(table,(byte)i);
        }
        return array;
    }


}
