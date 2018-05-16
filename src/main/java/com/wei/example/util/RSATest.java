package com.wei.example.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;

public class RSATest {

	public static void testRsa() {
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			
			String strpk = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALCNTLSu6DaV/8Iat91nbhNHLTpUZjbqC9tdgje2WONUFrwQFhKKbfoxtYvFZs/f8eey2pe3lcWvq9HVc3YawgkCAwEAAQ==";
			String strprivk = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAsI1MtK7oNpX/whq33WduE0ctOlRmNuoL212CN7ZY41QWvBAWEopt+jG1i8Vmz9/x57Lal7eVxa+r0dVzdhrCCQIDAQABAkAlLGs1NAqyy5yBWyzRkmCL8JWmTXUEJP2AH802O8+1dXmTtark5Qjk0ZK5Io1wqi0O15Dx5sSm7+QjQH0kJ5eNAiEA9zgD+Z0B/ybsM3j3dkF+lEZ+Ah3og75qHqUi0UTaFa8CIQC20rQbhWVymBTtwUzTPWhdcaCZmBwWncGIlu8RpCtJxwIhALditxgoDv4d+mMoXbE8XlBRhlG9q+hmjMPUzeIcyAYDAiBnQT2DxaV0QTygw2m2bJpDHGfOF8DVbSffEw/W8NeaBQIhAI/AILgHpz5A9CS1+LeXMv/MHdzt4IV0zPnUi08XGlsj";
			X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.decodeBase64(strpk.getBytes()));
		    PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(strprivk.getBytes()));

		    KeyFactory keyf = KeyFactory.getInstance("RSA", "BC");
		    PublicKey pubKey = keyf.generatePublic(pubX509);
		    PrivateKey privKey = keyf.generatePrivate(priPKCS8);
			
			RsaUtil rsaUtil =  new RsaUtil();
			String data = "luoguohui";
			System.out.println("加密前字符串：data=" + data);
			String encryptData = null;
			if (pubKey != null && (data != null && !data.equals(""))) {
				encryptData = rsaUtil.encryptData(data, pubKey);
				System.out.println("加密后字符串：encryptData=" + encryptData);
			}
			String descryptData = null;
			if (privKey != null && (encryptData != null && !encryptData.equals(""))) {
				descryptData = rsaUtil.decryptData(encryptData, privKey);
				System.out.println("解密后字符串：descryptData=" + descryptData);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		testRsa();
	}

}
