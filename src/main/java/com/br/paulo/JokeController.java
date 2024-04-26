package com.br.paulo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/joke")
public class JokeController {

    @Value("${jokeApi}")
    private String jokeApi;

    @GetMapping()
    public Object makeAJoke(@RequestParam String lang) {
        RestTemplate restTemplate = new RestTemplate();
        String url = jokeApi;
        if(lang != "") {
            url = jokeApi + "?lang=" + lang;
        }

        Object jokeResponse = restTemplate.getForObject(url, Object.class);
        return jokeResponse;
    }
}