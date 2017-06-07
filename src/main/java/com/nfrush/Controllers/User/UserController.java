package com.nfrush.Controllers.User;

import com.nfrush.Domains.JSON.Greeting;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by nfrush on 6/6/17.
 */
@Controller
public class UserController {

    private static final String template = "Identified User: %s!";
    private final AtomicLong counter = new AtomicLong();

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(method=GET, value = "/user")
    public @ResponseBody
    Greeting user(Principal principal) {
        UserDetails currentUser
                = (UserDetails) ((Authentication) principal).getPrincipal();
        return new Greeting(counter.incrementAndGet(), String.format(template, currentUser.getUsername()));
    }
}