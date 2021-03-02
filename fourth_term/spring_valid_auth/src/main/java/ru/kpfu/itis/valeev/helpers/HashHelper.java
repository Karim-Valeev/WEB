package ru.kpfu.itis.valeev.helpers;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashHelper {
    public static String getHash(String password) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        String salt = "ssp";
        password = salt + password;
        try{
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String resultHash = DatatypeConverter.printHexBinary(digest);

        return resultHash;
    }
}
