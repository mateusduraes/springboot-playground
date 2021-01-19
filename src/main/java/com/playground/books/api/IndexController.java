package com.playground.books.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/")
public class IndexController {

    @GetMapping
    public String hello() {
        return "Hello spring boot";
    }

    @GetMapping("/test")
    public String test() {
        return "Testing spring boot - another endpoint";
    }

}
