package com.hackathon.NLP.Processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.NLP.Models.sentiment;
import com.paralleldots.paralleldots.App;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class NLPProcessor {
    public static void main(String[] arg) throws Exception {
        process("[ \"Come on, lets play together\",\"Team performed well overall\" ]");
    }
    public static void process(String toParse) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        App pd = new App("ysI8xgSI1UTPyLzuv0Wh4qXh4SdXWzAVA3k1xh1NP6I");
        // for single sentences
//        String ner = pd.sentiment(toParse);
//        System.out.println(ner);
        // for multiple sentence as array

        JSONParser parser = new JSONParser();
        JSONArray text_list = (JSONArray)parser.parse(toParse);
        String sentiment_batch = pd.sentiment_batch(text_list);
        System.out.println(sentiment_batch);
//        sentiment x = mapper.readValue(sentiment_batch, sentiment.class);
        //        for(Sentiment x: sentimentResponse){
//            System.out.println(x.positive);
//        }
//        return x;
    }
}



        
