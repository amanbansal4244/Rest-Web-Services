package com.aman.services;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException {
		
		java.net.URL enPointURL = new java.net.URL("http://localhost:8089/2CalculatorService/services/CalService");
		
		org.apache.axis.client.Service service = new org.apache.axis.client.Service();
		
		CalServiceSoapBindingStub stub = new CalServiceSoapBindingStub(enPointURL, service);
		
		int addResult = stub.add(10, 20);
		System.out.println("Add result :"+ addResult);
		
		int subtractResult = stub.subtract(20, 5);
		System.out.println("Subtract result :"+ subtractResult);
	}
}
