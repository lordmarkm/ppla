package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.PplaUserService;
import com.ppla.core.dto.PplaUserInfo;

@RestController
@RequestMapping("/user")
public class PplaUserResource {

    private static Logger LOG = LoggerFactory.getLogger(PplaUserResource.class);

    @Autowired
    private PplaUserService service;

    @RequestMapping(method = GET)
    public ResponseEntity<PplaUserInfo> findByUsername(@RequestParam String username) {
        LOG.debug("Trying to find User by username. username={}", username);
        return new ResponseEntity<>(service.findByUsernameInfo(username), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<PplaUserInfo> save(Principal principal, @RequestBody PplaUserInfo profile) {
        LOG.debug("Trying to save profile. username={}, profile={}", principal.getName(), profile);
        profile.setUsername(principal.getName());
        return new ResponseEntity<>(service.saveInfo(profile), OK);
    }
}
