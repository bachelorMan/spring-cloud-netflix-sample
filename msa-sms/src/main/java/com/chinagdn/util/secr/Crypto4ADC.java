package com.chinagdn.util.secr;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;

public class Crypto4ADC
{

    public Crypto4ADC()
    {
    }

    public static String decode(String key, String cipher_value)
        throws GeneralSecurityException, UnsupportedEncodingException,Exception
    {
        // String plain_value_level2 = new String((new DES4ADC(key)).doDecrypt(BASE64.getBytesFromBASE64String(cipher_value)), DEFAULT_CHARSET);
        String plain_value_level2 = new String((new DES4ADC(key)).doDecrypt(Base64.getDecoder().decode(cipher_value.getBytes())));
        String forePart = plain_value_level2.substring(0, 32);
        String backEnd = plain_value_level2.substring(32);
        MessageDigest md = MessageDigest.getInstance("MD5");
        String backEnd2forePart = HexString.toHexString(md.digest(backEnd.getBytes(DEFAULT_CHARSET))).toLowerCase();
        if(!forePart.equals(backEnd2forePart))
            return null;
        else
            return backEnd;
    }

    public static String encode(String key, String plain_value)
        throws GeneralSecurityException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String forePart = HexString.toHexString(md.digest(plain_value.getBytes(DEFAULT_CHARSET))).toLowerCase();
        String backEnd = plain_value;
        String plain_text = forePart + backEnd;
        // return BASE64.toBASE64String((new DES4ADC(key)).doEncrypt(plain_text.getBytes(DEFAULT_CHARSET)));
		return Base64.getEncoder().encodeToString((new DES4ADC(key)).doEncrypt(plain_text.getBytes(DEFAULT_CHARSET)));
    }

    public static void main(String args[])
        throws Exception
    {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version = \"1.0\" encoding=\"UTF-8\"?>\n")
		.append("<TestCry>\n")
		.append("<Header>\n")
		.append("<MsgType>TestCry</MsgType>\n")
		.append("<TransationID>0001329901695000</TransationID>\n")
		.append("<TimeStamp>20120222170815000</TimeStamp>\n")
		.append("<Version>V1.0</Version>\n")
		.append("</Header>\n")
		.append("<Body>\n")
		.append("<Ret>0</Ret>\n")
		.append("</Body>\n")
		.append("</TestCry>\n");
        System.out.println(encode("98430FEB003E021E", sb.toString()));
        String encodeStr="a72Z3p4yge5t/5XVURy8VE+YAYOB0/Zzqgw/aZvwhs3hW6fQifK0TGQn0NDZYe/7mzAZTu3axrQyWso51WEsUF8cmkIRqbPWOiucXzekzXKoSWnJMfciUzCtLkPkNJiqfru0hNUJvLz3isdHzOYRa5NYt4wsoYAd2/NyF7X0KQsZNDFUk/DxoB/3dplysthI/NweGvposkDpdRGvEUUCn6gu41TN6fAAbJqGgZBPmNVqxwPqg5Fby/FGa3nJkQNv9C83iRww7wNFFkqhgrWdgmTdZt0exRdvPgLhsbUrBGKYeekY17nPztFIc9C5cUVZvIoIP/9UzojHd2v4ACDDUgbpPnZjtyyy9/BrroxpDN8n+Ce1hw0pLg==";
        System.out.println(decode("98430FEB003E021E", encodeStr));
    }

    private static final String DEFAULT_CHARSET = "UTF-8";
}