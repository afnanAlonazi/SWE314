package swe314Asignment;



import javax.crypto.*;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;



public class Encryptor {
	
static Scanner input = new Scanner(System.in);
static Encryptor encryptor = new Encryptor(); 
    //128 bit
     byte[] IV = { 0x01, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };//16 byte for 128 bits key

    //encryption method
    public String encrypt(String input, byte[] secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(secretKey,"AES");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV));
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
                
    }

    //decryption method
    public String decrypt(String cipherText, byte[] secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(secretKey,"AES");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV));
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
                
        return new String(plainText);
    }
    
 
    public byte[] stringToByteArray(String keyString){
        

        byte[] key = new byte[16];
        for (int i = 0; i < keyString.length(); i++) {
            key[i] = (byte) keyString.charAt(i);
        }
        return key;
    }
    
  
    // validation methods
    public static boolean isValidInput_key_plain(String input) {
        if (input == null) {
            return false;
        }
        
        if (input.length()!=16){
            return false;
        }
        
        // Check each character in the string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);{
            if (c < 0 || c > 127 ) {
            	return false;
            }
            if(c=='"' || c=='(' || c==')' || c==';' || c=='>' || c=='<' || c=='=' || c=='[' || c==']' || c=='{' || c=='}')
            {
                return false; // Character is outside the ASCII range or have a malicious character 
            }
        }
        }
        return true;
    }
   
}
