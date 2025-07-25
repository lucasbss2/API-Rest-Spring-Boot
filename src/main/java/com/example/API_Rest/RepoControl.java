package com.example.API_Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RepoControl {
    @GetMapping("/hello")
    public String hello() {
        return "Just a test for Spring boot and PostgreSQL";
    }
}