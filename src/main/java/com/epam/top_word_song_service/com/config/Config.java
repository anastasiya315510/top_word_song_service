package com.epam.top_word_song_service.com.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
@ComponentScan("com.epam.top_word_song_service.com")
public class Config {
    @Bean
    public  JavaSparkContext sc() {
        SparkConf conf = new SparkConf().setAppName("song").setMaster("local[*]");
        return new JavaSparkContext(conf);
    }



}


