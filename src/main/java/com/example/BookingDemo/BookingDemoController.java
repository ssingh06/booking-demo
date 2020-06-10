package com.example.BookingDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the rest controller that defines the default URLs.
 */
@RestController
public class BookingDemoController {

    /**
     * API: /
     * @return Welcome message
     */
    @RequestMapping("/")
    public String def() {
        return "Hello!";
    }

    /**
     * API: /hello
     * @return Welcome message
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    /**
     * API: /welcome
     * @return Welcome message
     */
    @RequestMapping("/welcome")
    public String welcome() {
        return "Hello!";
    }
}
