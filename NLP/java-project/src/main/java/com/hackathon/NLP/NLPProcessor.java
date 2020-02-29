package com.hackathon.NLP;

import com.paralleldots.paralleldots.App;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * Hello world!
 */
public class NLPProcessor {
    public static void main (String[] args) throws Exception {
        
        App pd = new App("ysI8xgSI1UTPyLzuv0Wh4qXh4SdXWzAVA3k1xh1NP6I");
        // for single sentences
        String ner = pd.ner("Apple was founded by Steve Jobs.\", \"en");
        System.out.println(ner);
        // for multiple sentence as array
    
        JSONParser parser = new JSONParser();
        JSONArray text_list = (JSONArray) parser.parse("[ \"Apple was founded by Steve Jobs\", \"Apple Inc. is an American multinational technology company headquartered in Cupertino.\"]");
        
        String ner_batch = pd.ner_batch(text_list);
        System.out.println(ner_batch);
    }
}



        
