/**
 * QBWebConnectorSvcSoapImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.intuit.developer;

public class QBWebConnectorSvcSoapImpl implements com.intuit.developer.QBWebConnectorSvcSoap{
    public java.lang.String serverVersion(java.lang.String strVersion) throws java.rmi.RemoteException {
    	System.out.println("serverVersion called");
        return null;
    }

    public java.lang.String clientVersion(java.lang.String strVersion) throws java.rmi.RemoteException {
    	System.out.println("clientVersion called");
    	return null;
    }

    public java.lang.String[] authenticate(java.lang.String strUserName, java.lang.String strPassword) throws java.rmi.RemoteException {
    	System.out.println("authenticate called");
    	return new String[]{"Turn", "down", "for", "what"};
    }

    public java.lang.String sendRequestXML(java.lang.String ticket, java.lang.String strHCPResponse, java.lang.String strCompanyFileName, java.lang.String qbXMLCountry, int qbXMLMajorVers, int qbXMLMinorVers) throws java.rmi.RemoteException {
    	System.out.println("sendRequestXML called");
    	return null;
    }

    public int receiveResponseXML(java.lang.String ticket, java.lang.String response, java.lang.String hresult, java.lang.String message) throws java.rmi.RemoteException {
    	System.out.println("receiveResponseXML called");
    	return -3;
    }

    public java.lang.String connectionError(java.lang.String ticket, java.lang.String hresult, java.lang.String message) throws java.rmi.RemoteException {
    	System.out.println("connectionError called");

    	return null;
    }

    public java.lang.String getLastError(java.lang.String ticket) throws java.rmi.RemoteException {
    	System.out.println("getLastError called");
    	return null;
    }

    public java.lang.String closeConnection(java.lang.String ticket) throws java.rmi.RemoteException {
    	System.out.println("closeConnection called");
        return null;
    }

}
