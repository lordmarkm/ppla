package com.ppla.app.util;

import static com.ppla.app.util.PplaConstants.RELOAD_CSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.baldy.commons.models.proper.Name;
import com.ppla.app.models.PplaUser;
import com.ppla.app.reference.PplaUserType;
import com.ppla.app.services.PplaUserService;
import static com.ppla.app.reference.PplaUserType.*;

/**
 * Loads data from orgchart.csv
 * @author mbmartinez
 */
@Component
@Transactional
public class PplaUserLoader {

    private static final Logger LOG = LoggerFactory.getLogger(PplaUserLoader.class);

    private static final String ORGCHART = "orgchart.csv";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_CODE = "Code";
    private static final String COLUMN_DEPARTMENT = "Department";
    private static final String COLUMN_FIRSTNAME = "First name";
    private static final String COLUMN_SURNAME = "Surname";
    private static final String COLUMN_TITLE = "Title";
    private static final String COLUMN_REPORTS_TO = "Reports_To";

    @Autowired
    private Environment env;

    @Autowired
    private PplaUserService service;

    @PostConstruct
    public void init() throws IOException {
        if (BooleanUtils.toBoolean(env.getProperty(RELOAD_CSV))) {
            reloadData();
        }
    }

    private void reloadData() throws IOException {
        LOG.debug("Reloading PplaUser from orgchart.csv");
        service.deleteAll();

        Resource resource = new ClassPathResource(ORGCHART);

        for (CSVRecord record : CSVFormat.RFC4180.withHeader().withDelimiter(',').parse(new InputStreamReader(resource.getInputStream()))) {
            PplaUser user = new PplaUser();
            user.setId(Long.parseLong(record.get(COLUMN_ID)));
            user.setCode(record.get(COLUMN_CODE));
            user.setType(determineUserType(record.get(COLUMN_DEPARTMENT)));
            user.setTitle(record.get(COLUMN_TITLE));
            user.setReportsTo(record.get(COLUMN_REPORTS_TO));

            Name name = new Name();
            name.setGivenName(record.get(COLUMN_FIRSTNAME));
            name.setSurname(record.get(COLUMN_SURNAME));
            user.setName(name);
            service.save(user);
        }
    }

    private PplaUserType determineUserType(String department) {
        switch (department) {
        case "Administration":
            return ADMIN;
        case "Management":
            return MANAGER;
        case "Cutting":
            return CUTTER;
        case "Extrusion":
            return EXTRUDER;
        case "Logistics":
            return WAREHOUSE;
        case "Mixing":
            return MIXER;
        case "Operations":
            return OPERATOR;
        case "Printing":
            return PRINTER;
        default:
            LOG.warn("Unrecognized department while parsing csv. dept={}", department);
            return OTHER;
        }
    }
}
