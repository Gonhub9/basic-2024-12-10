package com.ll.basic.domain.home.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final List<Integer> ages;

    @GetMapping("/ages")
    @ResponseBody
    public List<Integer> ages() {
        return ages;
    }
}
