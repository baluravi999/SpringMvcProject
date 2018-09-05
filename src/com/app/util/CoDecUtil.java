package com.app.util;


import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CoDecUtil {
	public String doEncode(String nrml)
	{
		System.out.println("Encoded:"+new String(Base64.encodeBase64(nrml.getBytes())));
		return new String(Base64.encodeBase64(nrml.getBytes()));
	}

	public String doDecode(String enc)
	{
		System.out.println("Decoded:"+new String(Base64.decodeBase64(enc.getBytes())));
		return new String(Base64.decodeBase64(enc.getBytes()));
	}
}
