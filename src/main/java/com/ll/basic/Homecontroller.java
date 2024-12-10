package com.ll.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller 어노테이션을 붙여주면 이 스프링부트가
@Controller
public class Homecontroller {
    private int age = 22;

    @GetMapping("/")
    @ResponseBody
    public String showMain() { return "안녕하세요."; }

    @GetMapping("/about")
    @ResponseBody
    public String showAbout() { return "저는 홍길동입니다."; }

    @GetMapping("/ageUp")
    @ResponseBody
    public int showAge() { return age++; }
}