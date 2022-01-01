package com.example.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void jasypt() {
        String url = "jdbc:127.0.0.1";
        String username = "my_db_username";
        String password = "my_db_password";

        System.out.println("======================== Encrypt");
        System.out.println("URL : " + jasyptEncoding(url));
        System.out.println("UserName : " + jasyptEncoding(username));
        System.out.println("PassWord : " + jasyptEncoding(password));
        System.out.println("========================\n");
        System.out.println("======================== Decrypt");
        System.out.println("URL : " + jasyptDecoding("cKK+8/DI/2yG48HDvyqepSlFqacFce/9"));
        System.out.println("UserName : " + jasyptDecoding("YvpChSLwxfqUH14HexJ6gWEwRlwA34sS"));
        System.out.println("PassWord : " + jasyptDecoding("V1ApR06fq0Riz61PyAXfFXSULiH2gh/P"));
        System.out.println("========================\n");
    }

    public String jasyptEncoding(String value) {

        String key = "my_jasypt_key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }


    public String jasyptDecoding(String value) {

        String key = "my_jasypt_key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.decrypt(value);
    }

}
