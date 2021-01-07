package com.epam.top_word_song_service.com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfigValue {

    public  static List<String> trash;

    @Value("${trash}")
    public void setDatabase(List<String> db) {
        trash = db;
    }
}
