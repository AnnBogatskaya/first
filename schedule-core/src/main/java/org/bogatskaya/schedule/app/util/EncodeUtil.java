package org.bogatskaya.schedule.app.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class EncodeUtil {

    public static String generateToken (String login) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");

        LocalDateTime localDateTime = LocalDateTime.now();

        byte[] token = Integer.toString(localDateTime.getSecond()).concat(login).getBytes();
        md.update(token);

        byte[] digest = md.digest();

        return DatatypeConverter.printHexBinary(digest)
                .toUpperCase();
    }

    public static String encodePassword (String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(password.getBytes());

        byte[] digest = md.digest();

        return DatatypeConverter.printHexBinary(digest)
                .toUpperCase();
    }
}
