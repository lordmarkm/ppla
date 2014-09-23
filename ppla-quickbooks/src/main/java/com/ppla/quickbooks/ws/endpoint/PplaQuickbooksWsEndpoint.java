package com.ppla.quickbooks.ws.endpoint;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cantero.quickbooks.ws.ArrayOfString;
import com.cantero.quickbooks.ws.ItemQueryRqSoapImpl;
import com.ppla.quickbooks.unmarshaller.QBXmlProcessor;

/*
 * http://developer.intuit.com/qbsdk-current/doc/pdf/qbwc_proguide.pdf
 */
@WebService(endpointInterface = "com.cantero.quickbooks.ws.QBWebConnectorSvcSoap")
@Service
public class PplaQuickbooksWsEndpoint extends ItemQueryRqSoapImpl {

    private static Logger LOG = LoggerFactory.getLogger(PplaQuickbooksWsEndpoint.class);

    @Autowired
    private QBXmlProcessor unmarshaller;

    @Override
    public ArrayOfString authenticate(String strUserName, String strPassword) {
        LOG.debug("authenticate(..) called");
        LOG.debug("strUserName={}", strUserName);
        LOG.debug("strPassword={}", strPassword);
        ArrayOfString arr = new ArrayOfString();
        //arr.string = new ArrayList<String>();
        arr.getString().add("The first element is a token for the web connector session");
        arr.getString().add(""); //To use the currently open company, specify an empty string
        return arr;
    }

    @Override
    public String closeConnection(String ticket) {
        LOG.debug("closeConnection(..) called");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String connectionError(String ticket, String hresult, String message) {
        LOG.debug("connectionError(..) called");

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLastError(String ticket) {
        LOG.debug("getLastError(..) called");

        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return A positive integer less than 100 represents the percentage of work completed. A value of 1 means one percent complete, a value of 100 means 100 percent complete--there is no more work. A negative value means an error has occurred and the Web Connector responds to this with a getLastError call. The negative value could be used as a custom error code.
     */
    @Override
    public int receiveResponseXML(String ticket, 
            String response,
            String hresult, String message) {
        LOG.debug("receiveResponseXML(..) called");
        LOG.debug("ticket={}", ticket);
        LOG.debug("response={}", response);
        LOG.debug("hresult={}", hresult);
        LOG.debug("message={}", message);
        if (response != null && response.length() > 0) {
            try {
            unmarshaller.unmarshall(response);
            } catch (Exception e) {
                LOG.error("Exception", e);
            }
        }
        // TODO Auto-generated method stub
        return 100;
    }

    @Override
    public String sendRequestXML(String ticket, String strHCPResponse,
            String strCompanyFileName, String qbXMLCountry, int qbXMLMajorVers,
            int qbXMLMinorVers) {
        LOG.debug("sendRequestXML(..) called");
        LOG.debug("ticket={}", ticket);
        LOG.debug("strHCPResponse={}", strHCPResponse);
        LOG.debug("strCompanyFileName={}", strCompanyFileName);
        LOG.debug("qbXMLCountry={}", qbXMLCountry);
        LOG.debug("qbXMLMajorVers={}", qbXMLMajorVers);
        LOG.debug("qbXMLMinorVers={}", qbXMLMinorVers);

        String query = unmarshaller.marshallInventoryRequest();
        LOG.debug("About to send request. request={}", query);
        return query;
    }

}
