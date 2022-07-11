package com.Encrypt.Encode;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Decode {
    public static String decode(String Key, @Nullable String Data, @Nullable byte[] otherdata) throws Exception {
        ArrayList<Byte> data;
        if(Data == null){
            if (otherdata == null){
                throw new Exception();
            }
            else{
                data = ArrayTools.ArraytoArraylist(otherdata);
            }

        }
        else{
            data = ArrayTools.ArraytoArraylist(Tools.strictStringToBytes(Data, StandardCharsets.US_ASCII));
        }






        String Key1 = new String(Key.substring(0, 64));
        byte[] Key1ToBytes;
        try {
            Key1ToBytes = Tools.strictStringToBytes(Key1, StandardCharsets.US_ASCII);
        } catch (
                CharacterCodingException e) {
            throw new Exception();
        }
        ArrayList<Byte> Key1ToArrayList = ArrayTools.ArraytoArraylist(Key1ToBytes);
        String Key2 = new String(Key.substring(64, 128));

        byte[] Key2ToBytes;
        try {
            Key2ToBytes = Tools.strictStringToBytes(Key2, StandardCharsets.US_ASCII);
        } catch (
                CharacterCodingException e) {
            throw new Exception();
        }
        ArrayList<Byte> Key2ToArrayList = ArrayTools.ArraytoArraylist(Key2ToBytes);
        String Key3 = new String(Key.substring(128, 192));
        byte[] Key3ToBytes;
        try {
            Key3ToBytes = Tools.strictStringToBytes(Key3, StandardCharsets.US_ASCII);
        } catch (
                CharacterCodingException e) {
            throw new Exception();
        }
        ArrayList<Byte> Key3ToArrayList = ArrayTools.ArraytoArraylist(Key3ToBytes);
        String Key4 = new String(Key.substring(192, 256));
        byte[] Key4ToBytes;
        try {
            Key4ToBytes = Tools.strictStringToBytes(Key4, StandardCharsets.US_ASCII);
        } catch (
                CharacterCodingException e) {
            throw new Exception();
        }
        ArrayList<Byte> Key4ToArrayList = ArrayTools.ArraytoArraylist(Key4ToBytes);

        byte[] replacetable1 = Table.GenerateReplaceTable(Key1ToArrayList);
        System.out.println(Arrays.toString(replacetable1));
        //System.out.println(Arrays.toString(replacetable1));
        //System.out.println(Arrays.toString(Table.GenerateReplaceTable(Key1ToArrayList)));
        byte[] replacetable2 = (Table.GenerateReplaceTable(Key2ToArrayList));
        byte[] replacetable3 = (Table.GenerateReplaceTable(Key3ToArrayList));
        byte[] replacetable4 = Table.GenerateReplaceTable(Key4ToArrayList);


        //ROUND4
        //System.out.println(data);
        //System.out.println(data.size());
        ArrayList<Byte> Bitwise4 = ArrayTools.BitwiseXOR(data,Key4ToArrayList);//clear

        ArrayList<ArrayList<Byte>> Split4 = SplitInto128Blocks.Split128(Bitwise4);
        //System.out.println(Split4);
        int rotateamount4 = Key4ToArrayList.get(2)+1;
        for(int i = 0 ; i < rotateamount4 ; i++){
            Split4 = ArrayTools.listLeftRotate(Split4);

        }
        System.out.println(Split4+"Split4");
        ArrayList<Byte> rotated4 = SplitInto128Blocks.join(Split4);
        System.out.println(rotated4+"Rotated");
        //System.out.println(rotated4);
        ArrayList<Byte> SubBytes4 = Table.SubBytes2(rotated4,replacetable4);
        System.out.println(SubBytes4);
        //System.out.println(SubBytes4);
        //round 3
        ArrayList<Byte> Bitwise3 = ArrayTools.BitwiseXOR(SubBytes4,Key4ToArrayList);
        ArrayList<ArrayList<Byte>> Split3 = SplitInto128Blocks.Split128(Bitwise3);
        int rotateamount3 = Key3ToArrayList.get(2)+1;
        for(int i = 0 ; i < rotateamount3 ; i++){
            Split3 = ArrayTools.listLeftRotate(Split3);
        }
        ArrayList<Byte> rotated3 = SplitInto128Blocks.join(Split3);
        ArrayList<Byte> SubBytes3 = Table.SubBytes2(rotated3,replacetable3);

        //  round 2
        ArrayList<Byte> Bitwise2 = ArrayTools.BitwiseXOR(SubBytes3,Key2ToArrayList);
        ArrayList<ArrayList<Byte>> Split2 = SplitInto128Blocks.Split128(Bitwise2);
        int rotateamount2 = Key2ToArrayList.get(2)+1;
        for(int i = 0 ; i < rotateamount2 ; i++){
            Split2 = ArrayTools.listLeftRotate(Split2);
        }
        ArrayList<Byte> rotated2 = SplitInto128Blocks.join(Split2);
        ArrayList<Byte> SubBytes2 = Table.SubBytes2(rotated2,replacetable2);

        //final round
        ArrayList<Byte> Bitwise1 = ArrayTools.BitwiseXOR(SubBytes2,Key1ToArrayList);
        ArrayList<ArrayList<Byte>> Split1 = SplitInto128Blocks.Split128(Bitwise1);
        int rotateamount1 = Key1ToArrayList.get(2)+1;
        for(int i = 0 ; i < rotateamount1 ; i++){
            Split1 = ArrayTools.listLeftRotate(Split1);
        }
        ArrayList<Byte> rotated1 = SplitInto128Blocks.join(Split1);

        ArrayList<Byte> SubBytes1 = Table.SubBytes2(rotated1,replacetable1);
       // System.out.println(SubBytes1);
        String Finished = new String(ArrayTools.ArraylistToarray(SubBytes1) , StandardCharsets.US_ASCII);
        //ArrayList<Byte>
       // System.out.println(Finished+"Finished");
        return Finished;
    }
    public static String Decode2(String Key, String data) throws Exception {

        ArrayList<Byte> bytekey = ArrayTools.ArraytoArraylist(Tools.strictStringToBytes(Key,StandardCharsets.US_ASCII));
        byte[] replacetable = Table.GenerateReplaceTable(bytekey);
        ArrayList<Byte> Data = ArrayTools.ArraytoArraylist(Tools.strictStringToBytes(data,StandardCharsets.US_ASCII));
        ArrayList<Byte> XOR = ArrayTools.BitwiseXOR(Data , bytekey);
        ArrayList<ArrayList<Byte>> hu = SplitInto128Blocks.Split128(XOR);
        int rotateamount = bytekey.get(2) + 1;
        System.out.println(rotateamount);
        for( int i = 0 ; i < rotateamount ; i++){
            hu = ArrayTools.listLeftRotate(hu);


        }
        ArrayList<Byte> Joined = SplitInto128Blocks.join(hu);
        ArrayList<Byte> finished = Table.SubBytes2(Joined,replacetable);
        System.out.println(finished);

        return new String(ArrayTools.ArraylistToarray(finished),StandardCharsets.US_ASCII);



    }
    public static String FullDecode(String Key , String Data) throws Exception {

        for( int i = 0 ; i < 4 ; i++){
            Data = Decode2(Key,Data);
        }
        return Data;

    }
}
