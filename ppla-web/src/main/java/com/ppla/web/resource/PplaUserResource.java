package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaUser;
import com.ppla.app.services.PplaUserService;
import com.ppla.core.dto.PplaUserInfo;
import com.tyrael.commons.mapper.dto.PageInfo;

@RestController
@RequestMapping("/user")
public class PplaUserResource {

    private static Logger LOG = LoggerFactory.getLogger(PplaUserResource.class);

    @Autowired
    private PplaUserService service;

    @Autowired
    private Mapper mapper;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<PplaUserInfo>> page(Principal principal,
            @RequestParam int page,
            @RequestParam int count) {

        LOG.debug("User query. Principal={}, page={}, count={}", principal, page, count);

        PageRequest pageRequest = new PageRequest(page - 1, count);

        Page<PplaUser> results = service.findAll(pageRequest);
        List<PplaUserInfo> userInfos = Lists.newArrayList();

        for (PplaUser user : results) {
            userInfos.add(mapper.map(user, PplaUserInfo.class));
        }

        PageInfo<PplaUserInfo> pageResponse = new PageInfo<>();
        pageResponse.setData(userInfos);
        pageResponse.setTotal(results.getTotalElements());

        return new ResponseEntity<>(pageResponse, OK);
    }

    @RequestMapping(method = GET, params = "type")
    public ResponseEntity<List<PplaUserInfo>> findByType(@RequestParam String type) {
        LOG.debug("Trying to find users by type. type={}", type);
        return new ResponseEntity<>(service.findByTypeInfo(type), OK);
    }

    @RequestMapping(method = GET, params = "username")
    public ResponseEntity<PplaUserInfo> findByUsername(@RequestParam String username) {
        LOG.debug("Trying to find User by username. username={}", username);
        return new ResponseEntity<>(service.findByUsernameInfo(username), OK);
    }

    @RequestMapping(method = GET, params = "code")
    public ResponseEntity<PplaUserInfo> findByCode(@RequestParam String code) {
        LOG.debug("Trying to find User by code. code={}", code);
        return new ResponseEntity<>(service.findByCodeInfo(code), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<PplaUserInfo> save(Principal principal, @RequestBody PplaUserInfo profile) {
        LOG.debug("Trying to save profile. username={}, profile={}", principal.getName(), profile);
        profile.setUsername(principal.getName());
        return new ResponseEntity<>(service.saveInfo(profile), OK);
    }

    @RequestMapping(value = "/operator", method = POST)
    public ResponseEntity<PplaUserInfo> addOperator(Principal principal, @RequestBody PplaUserInfo operator) {
        LOG.debug("Trying to save operator. operator={}", operator);
        return new ResponseEntity<>(service.saveInfo(operator), OK);
    }
}
