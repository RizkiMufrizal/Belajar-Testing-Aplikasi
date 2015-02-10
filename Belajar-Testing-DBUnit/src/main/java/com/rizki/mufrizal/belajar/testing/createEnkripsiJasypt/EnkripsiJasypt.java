package com.rizki.mufrizal.belajar.testing.createEnkripsiJasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EnkripsiJasypt {
    
    public static void main(String[]args){
        String algoritma = "PBEWithMD5AndTripleDES";
        String passwod = "administrator";
        String text = "jdbc:mariadb://localhost:3306/BelajarTesting";
        
        System.out.println("Hasil Enkripsi : ENC(" + enkripsiFile(algoritma, passwod, text) + ")");
        String enkripsi = enkripsiFile(algoritma, passwod, text);
        System.out.println("Hasil Dekripsi : " + dekripsiFile(algoritma, passwod, enkripsi));
    }
    
    public static String enkripsiFile(String algoritma, String password, String text){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

        encryptor.setAlgorithm(algoritma);
        encryptor.setPassword(password);

        return encryptor.encrypt(text);
    }
    
    public static String dekripsiFile(String algoritma, String password, String text){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        
        encryptor.setAlgorithm(algoritma);
        encryptor.setPassword(password);
        
        return encryptor.decrypt(text);
    }
}
