package com.app.util;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
private String getCommonStr(int len)
{
	return UUID.randomUUID().toString().replaceAll("-","").substring(0,len).toUpperCase();
}
public String getCommonStr()
{
		return getCommonStr(6);
}
public String genToken()
{
	System.out.println("Token:"+getCommonStr(8));
	return getCommonStr(8);
}

public String genPwd()
{ 
	System.out.println("Password:"+getCommonStr());

	return getCommonStr();
}
}