package com.Encrypt.Encode;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;


public class Execute {
public final String LegacyMethord = """
    @Contract("Hi plz help me :) ")
    public static String Encrypt(@NotNull String key ,@NotNull String key2 , @NotNull String key3, @NotNull String key4 ,  @NotNull String data)
            throws Exception{
        if( key.length() != 64 ){
            throw new Exception();
        }

        byte[] datatobyte;
        ArrayTools arraytool = new ArrayTools();
        Tools tools = new Tools();


        try{datatobyte = Tools.strictStringToBytes(data, StandardCharsets.US_ASCII);}
        catch(CharacterCodingException ignored) {throw new Exception();}
        ArrayList<Byte> nearlyfinished = ArrayTools.ArraytoArraylist(datatobyte);






        byte[] keytobyte;

        try{keytobyte = Tools.strictStringToBytes(key, StandardCharsets.US_ASCII);}
        catch(CharacterCodingException ignored) {throw new Exception();}

        ArrayList<Byte> bytekey = ArrayTools.ArraytoArraylist(keytobyte);
        try{keytobyte = Tools.strictStringToBytes(key2, StandardCharsets.US_ASCII);}
        catch(CharacterCodingException ignored) {throw new Exception();}

        ArrayList<Byte> bytekey2 = ArrayTools.ArraytoArraylist(keytobyte);
        try{keytobyte = Tools.strictStringToBytes(key3, StandardCharsets.US_ASCII);}
        catch(CharacterCodingException ignored) {throw new Exception();}

        ArrayList<Byte> bytekey3 = ArrayTools.ArraytoArraylist(keytobyte);
        try{keytobyte = Tools.strictStringToBytes(key4, StandardCharsets.US_ASCII);}
        catch(CharacterCodingException ignored) {throw new Exception();}

        ArrayList<Byte> bytekey4 = ArrayTools.ArraytoArraylist(keytobyte);



        byte[] replacetable = Table.GenerateReplaceTable(bytekey);
        ArrayList<Byte> nearlyfinished2 = Table.SubBytes(nearlyfinished , replacetable);
        ArrayList<ArrayList<Byte>> finished = SplitInto128Blocks.Split128(nearlyfinished2);
        int rotateamount = bytekey.get(2) + 1;
        for( int i = 0 ; i < rotateamount ; i++){
            finished = ArrayTools.listRightRotate(finished);
        }
        ArrayList<Byte> hu = SplitInto128Blocks.join(finished);
        ArrayList<Byte> done = ArrayTools.BitwiseXOR(hu , bytekey);
        System.out.println(done);
        // round 2
        byte[] replacetable2 = Table.GenerateReplaceTable(bytekey2);
        ArrayList<Byte> nearlyfinished22 = Table.SubBytes(done , replacetable2);
        ArrayList<ArrayList<Byte>> finished2 = SplitInto128Blocks.Split128(nearlyfinished22);
        int rotateamount2 = bytekey2.get(2) + 1;
        for( int i = 0 ; i < rotateamount2 ; i++){
            finished2 = ArrayTools.listRightRotate(finished2);
        }
        ArrayList<Byte> hu2 = SplitInto128Blocks.join(finished2);
        hu2 = ArrayTools.BitwiseXOR(hu2 , bytekey2);

        // round 3
        byte[] replacetable3 = Table.GenerateReplaceTable(bytekey3);
        ArrayList<Byte> nearlyfinished23 = Table.SubBytes(hu2 , replacetable3);
        ArrayList<ArrayList<Byte>> finished3 = SplitInto128Blocks.Split128(nearlyfinished23);
        int rotateamount3 = bytekey3.get(2) + 1;
        for( int i = 0 ; i < rotateamount3 ; i++){
            finished3 = ArrayTools.listRightRotate(finished3);
        }
        ArrayList<Byte> hu3 = SplitInto128Blocks.join(finished3);
        hu3 = ArrayTools.BitwiseXOR(hu3 , bytekey3);
        //round 4
        byte[] replacetable4 = Table.GenerateReplaceTable(bytekey4);
        System.out.println(hu3+"hu3");
        ArrayList<Byte> nearlyfinished24 = Table.SubBytes(hu3 , replacetable4);
        System.out.println(nearlyfinished24);
        ArrayList<ArrayList<Byte>> finished4 = SplitInto128Blocks.Split128(nearlyfinished24);
        int rotateamount4 = bytekey4.get(2) + 1;
        System.out.println(rotateamount4);
        for( int i = 0 ; i < rotateamount4 ; i++){
            finished4 = ArrayTools.listRightRotate(finished4);

        }
        System.out.println(finished4);
        ArrayList<Byte> hu4 = SplitInto128Blocks.join(finished4);
        System.out.println(hu4+"Xor");
        ArrayList<Byte> returnvariable = ArrayTools.BitwiseXOR(hu4 , bytekey4);
       // System.out.println(returnvariable+"Hi");
        byte[] returnvar = ArrayTools.ArraylistToarray(returnvariable);






        String returnvalue = new String(returnvar , StandardCharsets.US_ASCII);
        //System.out.println(returnvalue);
       // System.out.println(Arrays.toString(returnvar));
       // System.out.println(key);
       // System.out.println(key2);
       // System.out.println(key3);
       // System.out.println(key4);
        return returnvalue;
    }
""";
    public static String Encrypt2(@NotNull String key  ,  @NotNull ArrayList<Byte> Data)
            throws Exception{

        ArrayList<Byte> bytekey = ArrayTools.ArraytoArraylist(Tools.strictStringToBytes(key,StandardCharsets.US_ASCII));

        Data = SplitInto128Blocks.length128(Data);
        byte[] replacetable = Table.GenerateReplaceTable(bytekey);
        ArrayList<Byte> nearlyfinished2 = Table.SubBytes(Data , replacetable);
        ArrayList<ArrayList<Byte>> finished = SplitInto128Blocks.Split128(nearlyfinished2);
        int rotateamount = bytekey.get(2) + 1;

        for( int i = 0 ; i < rotateamount ; i++){
            finished = ArrayTools.listRightRotate(finished);
        }
        ArrayList<Byte> hu = SplitInto128Blocks.join(finished);
        ArrayList<Byte> done = ArrayTools.BitwiseXOR(hu , bytekey);


        System.out.println(done);
        return new String(ArrayTools.ArraylistToarray(done),StandardCharsets.US_ASCII);
    }

}

