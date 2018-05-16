package com.wei.example.util;

import com.wei.example.bean.ras.RasKey;
import org.apache.commons.codec.binary.Base64;

import java.security.*;

/**
 * @Description: BAS64加密算法工具
 * @Author: 魏俊杰
 * @CreateDate: 2018/5/2 16:55
 * @UpdateUser: 魏俊杰
 */
public class BAS64Utils {


    //生成一对儿公钥私钥
    public RasKey getRasKey(){
        RasKey rasKey = new RasKey();
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
            generator.initialize(512, new SecureRandom());
            KeyPair pair = generator.generateKeyPair();
            PublicKey pubKey = pair.getPublic();
            PrivateKey privKey = pair.getPrivate();
            byte[] pk = pubKey.getEncoded();
            byte[] privk = privKey.getEncoded();
            String strpk = new String(Base64.encodeBase64(pk));
            String strprivk = new String(Base64.encodeBase64(privk));

           rasKey.setStrpk(strpk);
           rasKey.setStrprivk(strprivk);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rasKey;
    }

}
