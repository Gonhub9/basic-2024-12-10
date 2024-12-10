package com.ll.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

// @Controller 어노테이션을 붙여주면 이 스프링부트가
@Controller
public class Homecontroller {
    private int age = 22;

    @GetMapping("/")
    @ResponseBody
    public String showMain() { return "안녕하세요."; }

    @GetMapping("/about")
    @ResponseBody
    public String showAbout() {
        return "저는 홍길동입니다.";
    }

    @GetMapping("/ageUp")
    @ResponseBody
    public int showAge() {
        return age++;
    }

    @GetMapping("/long")
    @ResponseBody
    public long getLong() {
        return 1000000000;
    }

    @GetMapping("/boolean")
    @ResponseBody
    public boolean getBoolean() {
        return true;
    }

    @GetMapping("/byte")
    @ResponseBody
    public byte getByte() {
        return 127;
    }

    @GetMapping("/short")
    @ResponseBody
    public short getShort() {
        return 32000;
    }

    @GetMapping("/char")
    @ResponseBody
    public char getChar() {
        return '꼭';
    }

    @GetMapping("/float")
    @ResponseBody
    public float getFloat() {
        return 3.14f;
    }

    @GetMapping("/double")
    @ResponseBody
    public double getDouble() {
        return 3.141592;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<String> getList() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/array")
    @ResponseBody
    public List<String> getArray() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/map")
    @ResponseBody
    public Map<String, String> getMap() {
        return Map.of("name ", "Paul", "hobby ", "reading");
    }

    @GetMapping("/article")
    @ResponseBody
    public Article getAticle() {
        return new Article();
    }
}

Class Article {
    private long id;

}