package com.fastcampus.practice.controller;

import com.fastcampus.practice.service.StringSortService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MainController {

    private final StringSortService stringSortService;

    public MainController(StringSortService stringSortService) {
        this.stringSortService = stringSortService;
    }

    @GetMapping("/")
    public String main(@RequestParam List<String> list) {
        return stringSortService.doSort(list).toString();
    }

    @PostMapping("/person")
    public String person(@RequestBody Person person) {
        log.info("name: {}", person.getName());
        log.info("age: {}", person.getAge());

        return "ok";
    }

}
