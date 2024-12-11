package com.ll.basic.domain.wiseSaying.wiseSaying.service;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Component를 붙이면 new를 할 필요가 없이 스프링부트가 알아서 만들어준다.
// Service와 Component의 차이는 '가독성'이다. 하지만 서비스에 해당하는 클래스는 Service를 사용하는 것이 좋다.
@Service
public class WiseSayingService {
    private final List<WiseSaying> wiseSayings;
    private long lastId;

    public WiseSayingService() {
        this.lastId = 0;
        this.wiseSayings = new ArrayList<>() {{
            add(
                    WiseSaying
                            .builder()
                            .id(++lastId)
                            .content("삶이 있는 한 희망은 있다")
                            .author("키케로")
                            .build()
            );

            add(
                    WiseSaying
                            .builder()
                            .id(++lastId)
                            .content("삶이 있는 한 희망은 있다")
                            .author("키케로")
                            .build()
            );

        }};
    }

    public List<WiseSaying> findAll() {

        return wiseSayings
                .stream()
                .sorted(Comparator.comparing(WiseSaying::getId).reversed())
                .toList();
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = WiseSaying
                .builder()
                .id(++lastId)
                .content(content)
                .author(author)
                .build();

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }
}
