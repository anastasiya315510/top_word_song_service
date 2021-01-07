package com.epam.top_word_song_service.com.controller;



import com.epam.top_word_song_service.com.service.WordHandler;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scala.Tuple2;

import java.util.List;


@RestController
@RequestMapping("/topX")
public class WordCountController {
    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private WordHandler wordHandler;


    @GetMapping("/{word}/{file}")
    public List<Tuple2<Long, String>> wordsCount(@PathVariable int word, @PathVariable String file){
        JavaRDD<String> list = sc.textFile("src/songs/" + file + ".txt");
            return wordHandler.countWord(word, list);

    }
}
