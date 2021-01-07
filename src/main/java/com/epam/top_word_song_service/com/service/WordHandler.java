package com.epam.top_word_song_service.com.service;

import org.apache.spark.api.java.JavaRDD;
import scala.Serializable;
import scala.Tuple2;

import java.util.List;


public interface WordHandler {

    List<Tuple2<Long, String>> countWord(int word, JavaRDD<String> list);

}
