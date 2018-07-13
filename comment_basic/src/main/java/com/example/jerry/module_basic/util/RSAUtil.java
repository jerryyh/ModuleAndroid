package com.example.jerry.module_basic.util;

import android.content.Context;
import android.util.Base64;

import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.crypto.Cipher;


/**
 * Created by Administrator on 2016/8/16.
 */
public class RSAUtil {
    /**
     * 加密方法
     *
     * @param source 源数据
     * @return 加密后的数据
     * @throws Exception
     */
    private static final String RSA = "RSA/ECB/PKCS1Padding";
    private static String PUBLIC_KEY_FILE = "assets/"+"rsacert.crt";
    private static String encryptStr="";
    private static String decryptStr="";

    public static String encrypt(Context context, String test){
        CertificateFactory cf ;
        try {
            cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert  = (X509Certificate)cf.generateCertificate(context.getClass().getClassLoader().getResourceAsStream(PUBLIC_KEY_FILE));
            Cipher encryptCipher = Cipher.getInstance(RSA);
            encryptCipher.init(Cipher.ENCRYPT_MODE, cert.getPublicKey());
            byte[] encryptBytes= encryptCipher.doFinal(test.getBytes());
            encryptStr= Base64.encodeToString(encryptBytes, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptStr;
    }

//    public static String deceypt(Context context,String crypt){
//        char[] privateKeyBytes="931027".toCharArray();
//        KeyStore keyStore = null;
//        try {
//            keyStore = KeyStore.getInstance("PKCS12");//"PKCS12"
//            keyStore.load(context.getResources().getAssets().open("p.p12"), privateKeyBytes);
//            String alias=keyStore.aliases().nextElement();
//            PrivateKey privateKey=(PrivateKey)keyStore.getKey(alias, privateKeyBytes);
//            Cipher decryptCipher = Cipher.getInstance(RSA);
//            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
//            byte[] decryptBytes= decryptCipher.doFinal(Base64.decode(crypt ,Base64.DEFAULT));
//            decryptStr=new String(decryptBytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptStr;
//    }

}
