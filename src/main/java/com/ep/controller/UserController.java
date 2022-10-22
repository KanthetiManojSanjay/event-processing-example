package com.ep.controller;

import com.ep.event.AuditEventPublisher;
import com.ep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kansanja on 22/10/22.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    AuditEventPublisher auditPublisher;

    @PostMapping
    public String register(@RequestBody User user) {
        auditPublisher.publishEvent("User registered successfully with " + user.getUsername());
        return "User registered successfully";
    }
}
