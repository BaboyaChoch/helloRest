package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String hiTemplate = "Hello, %s!";
    private static final String byeTemplateWithDate = "Good bye, %s! See you on the %s!";
    private static final String byeTemplateWithoutDate = "Good bye, %s! See you %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(hiTemplate, name));
    }

    @GetMapping("/bye")
    public Greeting bye(@RequestParam(value = "name", defaultValue = "Human") String name, @RequestParam(value = "nextDate", defaultValue = "tomorrow") String date) {

        return date.equals("tomorrow") ? new Greeting(counter.incrementAndGet(), String.format(byeTemplateWithoutDate, name, date)) : new Greeting(counter.incrementAndGet(), String.format(byeTemplateWithDate, name, date));
    }
}
