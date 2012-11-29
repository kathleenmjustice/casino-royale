package croyale.security;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.IvParameterSpec;

public class CRCipher
{
	// Encrypt a Serializable object with given key into a SealedObject
	public static SealedObject encrypt(Key key, Serializable o) throws IllegalBlockSizeException, IOException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		byte[] iv = new byte[16];
		new Random().nextBytes(iv);
		IvParameterSpec ips = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, ips);
		return new SealedObject(o, cipher);
	}
	
	// Decrypt a SealedObject encrypted with a given key into an Object
	public static Object decrypt(Key key, SealedObject so) throws InvalidKeyException, ClassNotFoundException, NoSuchAlgorithmException, IOException
	{
		return so.getObject(key);
	}
}