package cn.edu.nju.teamwiki.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
public class EncryptUtils {

    public static String encryptSHA(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(s.getBytes());
        return new BigInteger(md.digest()).toString(32);
    }


}
