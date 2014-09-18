/**
 * QBWebConnectorSvcSoapSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.intuit.developer;

public class QBWebConnectorSvcSoapSkeleton implements com.intuit.developer.QBWebConnectorSvcSoap, org.apache.axis.wsdl.Skeleton {
    private com.intuit.developer.QBWebConnectorSvcSoap impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "strVersion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("serverVersion", _params, new javax.xml.namespace.QName("http://developer.intuit.com/", "serverVersionResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://developer.intuit.com/", "serverVersion"));
        _oper.setSoapAction("http://developer.intuit.com/serverVersion");
        _myOperationsList.add(_oper);
        if (_myOperations.get("serverVersion") == null) {
            _myOperations.put("serverVersion", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("serverVersion")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "strVersion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("clientVersion", _params, new javax.xml.namespace.QName("http://developer.intuit.com/", "clientVersionResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://developer.intuit.com/", "clientVersion"));
        _oper.setSoapAction("http://developer.intuit.com/clientVersion");
        _myOperationsList.add(_oper);
        if (_myOperations.get("clientVersion") == null) {
            _myOperations.put("clientVersion", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("clientVersion")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "strUserName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "strPassword"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("authenticate", _params, new javax.xml.namespace.QName("http://developer.intuit.com/", "authenticateResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://developer.intuit.com/", "ArrayOfString"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://developer.intuit.com/", "authenticate"));
        _oper.setSoapAction("http://developer.intuit.com/authenticate");
        _myOperationsList.add(_oper);
        if (_myOperations.get("authenticate") == null) {
            _myOperations.put("authenticate", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("authenticate")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "strHCPResponse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "strCompanyFileName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "qbXMLCountry"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "qbXMLMajorVers"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "qbXMLMinorVers"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("sendRequestXML", _params, new javax.xml.namespace.QName("http://developer.intuit.com/", "sendRequestXMLResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://developer.intuit.com/", "sendRequestXML"));
        _oper.setSoapAction("http://developer.intuit.com/sendRequestXML");
        _myOperationsList.add(_oper);
        if (_myOperations.get("sendRequestXML") == null) {
            _myOperations.put("sendRequestXML", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("sendRequestXML")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "response"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "hresult"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "message"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("receiveResponseXML", _params, new javax.xml.namespace.QName("http://developer.intuit.com/", "receiveResponseXMLResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://developer.intuit.com/", "receiveResponseXML"));
        _oper.setSoapAction("http://developer.intuit.com/receiveResponseXML");
        _myOperationsList.add(_oper);
        if (_myOperations.get("receiveResponseXML") == null) {
            _myOperations.put("receiveResponseXML", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("receiveResponseXML")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "hresult"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "message"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("connectionError", _params, new javax.xml.namespace.QName("http://developer.intuit.com/", "connectionErrorResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://developer.intuit.com/", "connectionError"));
        _oper.setSoapAction("http://developer.intuit.com/connectionError");
        _myOperationsList.add(_oper);
        if (_myOperations.get("connectionError") == null) {
            _myOperations.put("connectionError", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("connectionError")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getLastError", _params, new javax.xml.namespace.QName("http://developer.intuit.com/", "getLastErrorResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://developer.intuit.com/", "getLastError"));
        _oper.setSoapAction("http://developer.intuit.com/getLastError");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getLastError") == null) {
            _myOperations.put("getLastError", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getLastError")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.intuit.com/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("closeConnection", _params, new javax.xml.namespace.QName("http://developer.intuit.com/", "closeConnectionResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://developer.intuit.com/", "closeConnection"));
        _oper.setSoapAction("http://developer.intuit.com/closeConnection");
        _myOperationsList.add(_oper);
        if (_myOperations.get("closeConnection") == null) {
            _myOperations.put("closeConnection", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("closeConnection")).add(_oper);
    }

    public QBWebConnectorSvcSoapSkeleton() {
        this.impl = new com.intuit.developer.QBWebConnectorSvcSoapImpl();
    }

    public QBWebConnectorSvcSoapSkeleton(com.intuit.developer.QBWebConnectorSvcSoap impl) {
        this.impl = impl;
    }
    public java.lang.String serverVersion(java.lang.String strVersion) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.serverVersion(strVersion);
        return ret;
    }

    public java.lang.String clientVersion(java.lang.String strVersion) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.clientVersion(strVersion);
        return ret;
    }

    public java.lang.String[] authenticate(java.lang.String strUserName, java.lang.String strPassword) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.authenticate(strUserName, strPassword);
        return ret;
    }

    public java.lang.String sendRequestXML(java.lang.String ticket, java.lang.String strHCPResponse, java.lang.String strCompanyFileName, java.lang.String qbXMLCountry, int qbXMLMajorVers, int qbXMLMinorVers) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.sendRequestXML(ticket, strHCPResponse, strCompanyFileName, qbXMLCountry, qbXMLMajorVers, qbXMLMinorVers);
        return ret;
    }

    public int receiveResponseXML(java.lang.String ticket, java.lang.String response, java.lang.String hresult, java.lang.String message) throws java.rmi.RemoteException
    {
        int ret = impl.receiveResponseXML(ticket, response, hresult, message);
        return ret;
    }

    public java.lang.String connectionError(java.lang.String ticket, java.lang.String hresult, java.lang.String message) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.connectionError(ticket, hresult, message);
        return ret;
    }

    public java.lang.String getLastError(java.lang.String ticket) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getLastError(ticket);
        return ret;
    }

    public java.lang.String closeConnection(java.lang.String ticket) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.closeConnection(ticket);
        return ret;
    }

}
