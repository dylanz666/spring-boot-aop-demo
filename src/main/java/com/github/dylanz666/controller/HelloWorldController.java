package com.github.dylanz666.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : dylanz
 * @since : 10/22/2020
 */
@RestController
public class HelloWorldController {
    @GetMapping("/api/hello")
    public String sayHello(@RequestParam String user) {
        return "Hello " + user;
    }
}
