package com.lsp.core.common;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by songbo on 2018/8/7.
 */
public class PasswordUtils {

    public static final String ALGORITHM_NAME = "MD5";
    public static final int HASH_ITERATIONS = 24;

    public static String getPassword(String password,String salt){
        SimpleHash hash = new SimpleHash(ALGORITHM_NAME,password,salt,HASH_ITERATIONS);
        return hash.toString();
    }

    public static void main(String[] args){
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        System.out.print(getPassword("123","b18245")+"==="+"b18245");
    }
}
