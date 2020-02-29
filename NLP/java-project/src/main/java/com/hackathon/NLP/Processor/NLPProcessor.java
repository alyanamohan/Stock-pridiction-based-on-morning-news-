package com.hackathon.NLP.Processor;

import com.paralleldots.paralleldots.App;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json4s.jackson.Json;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 */
public class NLPProcessor {
    public static void main(String[] arg) throws Exception {
        process("[ \"Come on, lets play together\",\"Team performed well overall\" ]");
    }
    public static void process(String toParse) throws Exception {
        App pd = new App("ysI8xgSI1UTPyLzuv0Wh4qXh4SdXWzAVA3k1xh1NP6I");
        // for single sentences
//        String ner = pd.sentiment(toParse);
//        System.out.println(ner);
        // for multiple sentence as array

        JSONParser parser = new JSONParser();
        JSONArray text_list = (JSONArray)parser.parse(toParse);
        String sentiment_batch = pd.sentiment_batch(text_list);
        System.out.println(sentiment_batch);

    }
}



        
