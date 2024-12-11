package com.ll.basic.domain.wiseSaying.wiseSaying.controller;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody // 여기에 붙이면 모든 메서드에 적용
@RequiredArgsConstructor // 생성자를 자동으로 만들어줌, final 붙은 필드를 자동으로 초기화해주는 어노테이션

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;

    // @Autowired로 필요한 것이 있으면 () 안에 적어라. 근데 생략 가능
    // @Autowired

    @GetMapping("/wiseSayings")
    public List<WiseSaying> getItems() {
        return wiseSayingService.findAll();
    }

}
