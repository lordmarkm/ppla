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
import com.ppla.quickbooks.entity.generated.ItemQueryRsType;
import com.ppla.quickbooks.entity.generated.QBXML;
import com.ppla.quickbooks.entity.generated.QBXMLMsgsRq;
import com.ppla.quickbooks.entity.generated.SalesOrderQueryRqType;
import com.ppla.quickbooks.entity.generated.SalesOrderQueryRsType;
import com.ppla.quickbooks.service.InventoryItemService;

@Component
public class QBXmlProcessor {

    private static Logger LOG = LoggerFactory.getLogger(QBXmlProcessor.class);
    private static JAXBContext jc;

    @Autowired
    private InventoryItemService itemService;

    @Autowired
    private ItemQueryResponseProcessor itemProcessor;

    @Autowired
    private ItemQueryRequestComposer itemQueryRequestComposer;

    @Autowired
    private SalesOrderQueryResponseProcessor salesOrderProcessor;

    @Autowired
    private SalesOrderQueryComposer salesOrderQueryComposer;

    @PostConstruct
    public void initJaxbContext() throws JAXBException {
        jc = JAXBContext.newInstance(QBXML.class);
    }

    public String marshallInventoryRequest() {
        ItemQueryRqType itemQuery = itemQueryRequestComposer.createItemQuery();
        SalesOrderQueryRqType salesOrderQuery = salesOrderQueryComposer.createSalesOrderQuery();
        
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

    public void processResponseCollection(List<Object> rsCollection) {
        for (Object o : rsCollection) {
            LOG.debug("Processing response collection. class={}", o.getClass().getName());
            if (o instanceof ItemQueryRsType) {
                itemProcessor.processItemQueryResponse((ItemQueryRsType) o);
            } else if (o instanceof SalesOrderQueryRsType) {
            	salesOrderProcessor.processSalesOrderQueryResponse((SalesOrderQueryRsType) o);
            } else {
            	LOG.warn("Unhandled response class. class={}", o.getClass());
            }
        }
    }

}
