package com.hackathon.NLP.Processor;

import com.hackathon.NLP.Models.Article;
import com.hackathon.NLP.Models.Paragraph;
import com.hackathon.NLP.Models.Probabilities;
import com.hackathon.NLP.Requests.StockInfoPost;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;


public class MapBuilder {

//    public static void main(String[] s) throws Exception {
//        build();
//    }

    public Map<String, Probabilities> build() throws Exception {
        Map<String, Probabilities> stocks = new TreeMap<>();;
        StockInfoPost retrievedData = ArticleParser.parse();
        for(Article article: retrievedData.articles){
            TimeUnit.SECONDS.sleep(30);
            Probabilities probability = NLPProcessor.process(article.paragraphs.get(0).text);
                for(String t: article.paragraphs.get(0).ticker){
                    stocks.put(t,probability);
                }
            }
        return stocks;
    }
}
