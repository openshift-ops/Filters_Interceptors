package com.springboot.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class HomeController {


    @GetMapping("/home")
    public List<Integer> getHome()
    {
        return IntStream.rangeClosed(0,10).boxed().collect(Collectors.toList());
    }

    @GetMapping("/second")
    public Integer getSecondLargest()
    {
        List<Integer> integerList = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
        Comparator<Integer> comparator = Integer::compareTo;
        return integerList.stream().sorted(comparator.reversed()).collect(Collectors.toList()).get(1);
    }
}
