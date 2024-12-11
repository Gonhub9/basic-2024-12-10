package com.ll.basic.domain.wiseSaying.wiseSaying.controller;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WiseSayingController {
    private final WiseSayingService wiseSayingService;

    public WiseSayingController () {
        this.wiseSayingService = new WiseSayingService();

    }

    @GetMapping("/wiseSayings")
    @ResponseBody
    public List<WiseSaying> getItems() {
        return wiseSayingService.findAll();
    }
}
