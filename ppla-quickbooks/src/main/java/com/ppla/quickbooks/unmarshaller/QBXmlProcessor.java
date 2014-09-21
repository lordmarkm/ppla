package com.ppla.quickbooks.unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ppla.quickbooks.entity.generated.ItemQueryRqType;
import com.ppla.quickbooks.entity.generated.ModifiedDateRangeFilter;
import com.ppla.quickbooks.entity.generated.QBXML;
import com.ppla.quickbooks.entity.generated.QBXMLMsgsRq;
import com.ppla.quickbooks.entity.generated.SalesOrderQueryRqType;
import com.ppla.quickbooks.service.InventoryItemService;

@Component
public class QBXmlProcessor {

    private static Logger LOG = LoggerFactory.getLogger(QBXmlProcessor.class);
    private static JAXBContext jc;

    @Autowired
    private InventoryItemService itemService;

    @PostConstruct
    public void initJaxbContext() throws JAXBException {
        jc = JAXBContext.newInstance(QBXML.class);
    }

    public String marshallInventoryRequest() {
        ItemQueryRqType itemQuery = createItemQuery();
        SalesOrderQueryRqType salesOrderQuery = createSalesOrderQuery();
        
        QBXMLMsgsRq rq = new QBXMLMsgsRq();
        rq.setOnError("stopOnError");
        rq.getHostQueryRqOrCompanyQueryRqOrCompanyActivityQueryRq().add(itemQuery);
        rq.getHostQueryRqOrCompanyQueryRqOrCompanyActivityQueryRq().add(salesOrderQuery);

        QBXML qbxml = new QBXML();
        qbxml.setQBXMLMsgsRq(rq);

        try {
            StringWriter sw = new StringWriter();
            sw.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><?qbxml version=\"7.0\"?>");
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            m.marshal(qbxml, sw);
            return sw.toString();
        } catch (JAXBException e) {
            LOG.error("Error marshalling request.", e);
            return "";
        }
    }

    private SalesOrderQueryRqType createSalesOrderQuery() {
        ModifiedDateRangeFilter soDateFilter = new ModifiedDateRangeFilter();
        soDateFilter.setFromModifiedDate("2014-09-19T16:57:59+08:00");
        SalesOrderQueryRqType salesOrderQuery = new SalesOrderQueryRqType();
        salesOrderQuery.getOwnerID().add("0");
        salesOrderQuery.setRequestID("12345");
        salesOrderQuery.setModifiedDateRangeFilter(soDateFilter);
        salesOrderQuery.setIncludeLineItems("true");

        return salesOrderQuery;
    }

    private ItemQueryRqType createItemQuery() {
        ItemQueryRqType itemQuery = new ItemQueryRqType();
        //itemQuery.setFromModifiedDate(itemService.getLastModifiedDate());
        itemQuery.setFromModifiedDate("2014-09-19T16:57:59+08:00");
        itemQuery.setRequestID("SXRlbVF1ZXJ5fDEyMA==");
        itemQuery.getOwnerID().add("0");

        LOG.debug("Querying from last modified date={}", itemQuery.getFromModifiedDate());

        return itemQuery;
    }

    public void unmarshall(String xml) {
        QBXML qbxml = null;
        try {
            Unmarshaller u = jc.createUnmarshaller();
            qbxml = (QBXML) u.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            LOG.error("Error unmarshalling XML.", e);
            return;
        }
        LOG.debug("Successfully unmarshalled qbxml. Rs status code={}", qbxml.getQBXMLMsgsRs().getMessageSetStatusCode());

        List<Object> rsCollection = qbxml.getQBXMLMsgsRs().getHostQueryRsOrCompanyQueryRsOrCompanyActivityQueryRs();
        processResponseCollection(rsCollection);

        LOG.debug("RS collection length={}", rsCollection.size());
    }

    private void processResponseCollection(List<Object> rsCollection) {
        for (Object o : rsCollection) {
            LOG.debug("collection member class={}", o.getClass().getName());
        }
    }

}
