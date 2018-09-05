package com.app;

import javax.xml.ws.Endpoint;

public class Publisher {
public static void main(String[] args) {
	String addr="http://localhost:7777/sample";
	Calculation obj=new Calculation();
	Endpoint.publish(addr,obj);
	System.out.println("done");
}
}
