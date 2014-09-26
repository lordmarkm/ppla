package com.ppla.quickbooks.util;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.stereotype.Service;

//http://www.programcreek.com/java-api-examples/index.php?api=org.joda.time.format.DateTimeFormatterBuilder
@Service
public class QBDateAdapter {

    DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
    DateTimeParser[] parsers = { 
            ISODateTimeFormat.dateTimeNoMillis().getParser(),
            ISODateTimeFormat.dateTime().getParser(),
            DateTimeFormat.forPattern( "yyyy-MM-ddZ" ).withZone(DateTimeZone.getDefault()).getParser()
             };
    DateTimeFormatter dtf;

    @PostConstruct
    public void init() {
        builder.append(ISODateTimeFormat.dateTimeNoMillis().getPrinter(), parsers);
        dtf = builder.toFormatter();
    }

    public String format(DateTime time) {
        return dtf.print(time != null ? time : DateTime.now());
    }
}