package com.epam.top_word_song_service.com.service;

import com.epam.top_word_song_service.com.config.ConfigValue;
import org.apache.spark.api.java.JavaRDD;
import org.springframework.stereotype.Service;
import scala.Tuple2;
import java.util.Arrays;
import java.util.List;



@Service
class WordHandlerImpl implements WordHandler {


    @Override
    public List<Tuple2< Long, String>>  countWord(int word, JavaRDD<String> list) {

            return list
                    .map(String::toLowerCase)
                    .map(s -> s.replaceAll("\\p{Punct}", ""))
                    .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                    .filter(s -> !ConfigValue.trash.contains(s))
                    .mapToPair(str -> new Tuple2<>(str, 1L))
                    .reduceByKey((v, k) -> v + k)
                    .mapToPair(Tuple2::swap)
                    .sortByKey(false)
                    .take(word);


    }




}
