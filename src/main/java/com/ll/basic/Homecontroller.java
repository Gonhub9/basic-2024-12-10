package com.ll.basic;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// @Controller 어노테이션을 붙여주면 이 스프링부트가
@Controller
public class Homecontroller {
    private int age = 22;

    @GetMapping("/")
    @ResponseBody
    public String showMain() {
        return "안녕하세요.";
    }

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
    public Article getArticle() {
        return Article
                .builder()
                .title("제목")
                .body("내용")
                .build();
    }

    @GetMapping("/articleList")
    @ResponseBody
    public List<Article> getArticles() {
        return List.of(
                Article.builder().title("제목1").body("내용1").build(),
                Article.builder().title("제목2").body("내용2").build()
        );
    }

    @GetMapping("/articleMap")
    @ResponseBody
    public Map<String, Article> articleMap() {
        return Map.of(
                "article1", Article.builder().title("제목1").body("내용1").build(),
                "article2", Article.builder().title("제목2").body("내용2").build()
        );

    }

    @GetMapping("/articleList.html")
    @ResponseBody
    public String getArticlesDoHtml() {
        Article article1 = Article.builder().id(1).title("제목1").body("내용1").build();
        Article article2 = Article.builder().id(2).title("제목2").body("내용2").build();
        Article article3 = Article.builder().id(3).title("제목3").body("내용3").build();
        Article article4 = Article.builder().id(4).title("제목4").body("내용4").build();

        List<Article> articles = List.of(article1, article2, article3, article4);

        String lis = articles
                .stream()
                .map(article -> "<li>%d번 / %s</li>".formatted(article.getId(), article.getTitle()))
                .collect(Collectors.joining("\n"));

        return "<ul style=\"font-weight: bold; color : red;\">\n" + lis + "\n</ul>";
    }
}

@Getter
@Builder
class Article {
    @Builder.Default
    private long id = 1L;
    private final String title;
    private final String body;
    @Builder.Default
    private boolean Published = true;
}