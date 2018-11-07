package com.hang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hang
 */
@RestController
@Slf4j
public class TestController {
    @GetMapping("/test/hello")
    public String test(){
        log.info("hello");
        return "hello";
    }
}
