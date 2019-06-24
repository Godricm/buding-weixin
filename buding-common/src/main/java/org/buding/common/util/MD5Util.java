package org.buding.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private static final String SALT="buding";

    public static String encode(String password){
        password=password+SALT;
        MessageDigest md5=null;

        try {
            md5=MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        char[] charArray=password.toCharArray();
        byte[] byteArray=new byte[charArray.length];

        for (int i=0;i<charArray.length;i++){
            byteArray[i]=(byte)charArray[i];


        }
        byte[] md5Bytes=md5.digest(byteArray);
        StringBuffer hexValue=new StringBuffer();
        for (int i=0;i<md5Bytes.length;i++){
            int val=((int)md5Bytes[i]) & 0xff;
            if(val<16){
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(i));
        }
        return hexValue.toString();
    } 
}
