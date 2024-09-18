import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryptionUtil{
	private static final String AES_KEY = "0123456789012345";
	private static final String AES = "AES";
	
	public static SecretKey getAESKey() {
		return new SecretKeySpec(AES_KEY.getBytes(),AES);
	}
	
	public static String encrypt(String message,SecretKey key) throws Exception{
		Cipher cipher = Cipher.getInstance(AES);
		cipher.init(Cipher.ENCRYPT_MODE,key);
		
		byte[] encryptedBytes = cipher.doFinal(message.getBytes());
		
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}
	
	public static String decrypt(String encryptedMessage, SecretKey key ) throws Exception {
		Cipher cipher = Cipher.getInstance(AES);
		cipher.init(Cipher.DECRYPT_MODE,key);
		
		byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
		byte[] decryptedBytes = cipher.doFinal(decodedBytes);
		
		return new String(decryptedBytes);
	}
}
