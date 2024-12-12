package com.ll.basic.domain.wiseSaying.wiseSaying.controller;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // 여기에 붙이면 모든 메서드에 적용
@RequestMapping("/wiseSayings")
@RequiredArgsConstructor // 생성자를 자동으로 만들어줌, final 붙은 필드를 자동으로 초기화해주는 어노테이션
public class WiseSayingController {
    private final WiseSayingService wiseSayingService;

    // @Autowired로 필요한 것이 있으면 () 안에 적어라. 근데 생략 가능
    // @Autowired
    @GetMapping
    public List<WiseSaying> getItems() {
        return wiseSayingService.findAll();
    }

    @GetMapping("/write")
    public WiseSaying write(
            // ? 뒤에 content 파라미터 값이 들어온다.
            String content,
            @RequestParam(defaultValue = "무명") String author
    ) {
        return wiseSayingService.write(content, author);
    }

    @GetMapping("/{id}")
    public WiseSaying getItem(
            @PathVariable (name = "id") long id
    ) {
        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        return opWiseSaying.get();
    }

    @GetMapping("/{id}/delete")
    public boolean deleteItem(
            @PathVariable (name = "id") long id
    ) {
        return wiseSayingService.deleteById(id);
    }

    @GetMapping("/{id}/modify")
    public WiseSaying modifyItem(
            @PathVariable (name = "id") long id,
            @RequestParam (name = "content") String content,
            @RequestParam (name = "author" ,defaultValue = "무명") String author
    ) {
        WiseSaying wiseSaying = wiseSayingService.findById(id).get();

        wiseSayingService.modify(wiseSaying, content, author);

        return wiseSaying;
    }


}