package com.example.keycloakspringbootmicroserviceapp1.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/test")
public class KeycloakController1 {


    @RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Hello Anonymous");
    }

    @RolesAllowed("user")
    @GetMapping(value = "/user")
    public ResponseEntity<String> getUser(@RequestHeader("Authorization") String Authorization) {
        return ResponseEntity.ok("Hello User");
    }

    //@RolesAllowed("admin")
    //@RequestMapping(value = "/admin", method = RequestMethod.GET)
    @GetMapping(value = "/admin")
    public ResponseEntity<String> getAdmin(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello Admin");
    }

    //@RolesAllowed({ "admin", "user" })
    @RequestMapping(value = "/all-user", method = RequestMethod.GET)
    public ResponseEntity<String> getAllUser(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello All User");
    }
}
