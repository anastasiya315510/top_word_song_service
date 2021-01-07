package com.epam.top_word_song_service.com.service;

import com.epam.top_word_song_service.com.config.Config;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class WordHandlerImplTest {

    @Autowired
    private  JavaSparkContext sc;
    @Autowired
    private WordHandler word;

    @After
    public  void tearDown() throws Exception {
        sc.close();
    }

    @Test
    public void countWord() {
        JavaRDD<String> rdd = sc.parallelize(List.of("test", "test", "test"));
        Assert.assertEquals("test", word.countWord(1, rdd).get(0)._2);

    }
}