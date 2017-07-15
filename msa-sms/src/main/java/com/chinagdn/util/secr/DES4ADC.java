package com.chinagdn.util.secr;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

class DES4ADC
{

    public DES4ADC(String hexString)
    {
        iv = new IvParameterSpec(new byte[8]);
        desKey = HexString.toBytes(hexString);
    }

    public DES4ADC(byte desKey[])
    {
        iv = new IvParameterSpec(new byte[8]);
        this.desKey = desKey;
    }

    public byte[] doDecrypt(byte encryptText[])
        throws GeneralSecurityException
    {
        byte rawKeyData[] = desKey;
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        javax.crypto.SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, key, iv);
        byte encryptedData[] = encryptText;
        byte decryptedData[] = cipher.doFinal(encryptedData);
        return decryptedData;
    }

    public byte[] doEncrypt(byte plainText[])
        throws GeneralSecurityException
    {
        byte rawKeyData[] = desKey;
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        javax.crypto.SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, key, iv);
        byte data[] = plainText;
        byte encryptedData[] = cipher.doFinal(data);
        return encryptedData;
    }

    private byte desKey[];
    private IvParameterSpec iv;
}