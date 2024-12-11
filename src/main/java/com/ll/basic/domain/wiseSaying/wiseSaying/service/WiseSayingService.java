package com.ll.basic.domain.wiseSaying.wiseSaying.service;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.repository.WiseSayingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Component를 붙이면 new를 할 필요가 없이 스프링부트가 알아서 만들어준다.
// Service와 Component의 차이는 '가독성'이다. 하지만 서비스에 해당하는 클래스는 Service를 사용하는 것이 좋다.
@Service
@RequiredArgsConstructor
public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = WiseSaying
                .builder()
                .content(content)
                .author(author)
                .build();
        wiseSayingRepository.save(wiseSaying);
        return wiseSaying;
    }

    public Optional<WiseSaying> findById(long id) {
        return wiseSayingRepository.findById(id);
    }

    public boolean deleteById(long id) {
        return wiseSayingRepository.deleteById(id);
    }
}
