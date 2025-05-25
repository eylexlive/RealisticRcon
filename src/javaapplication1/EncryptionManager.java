package javaapplication1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class EncryptionManager {
    public static String sifrele(String text) {
        try {
           MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
           messageDigestNesnesi.update(text.getBytes());
           byte messageDigestDizisi[] = messageDigestNesnesi.digest();
           StringBuffer sb16 = new StringBuffer();
           for (int i = 0; i < messageDigestDizisi.length; i++) {
               sb16.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
            }
           return sb16.toString();
        } catch(NoSuchAlgorithmException e){
           System.err.println(e);
       }
    return null;
    }
}
