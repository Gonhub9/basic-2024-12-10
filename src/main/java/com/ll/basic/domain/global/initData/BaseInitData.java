package com.ll.basic.domain.global.initData;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BaseInitData {
    @Bean
    public List<Integer> ages() {
        return List.of (10, 20, 30, 40, 50);
    }
}
