package com.hackathon.NLP.Processor;

import com.hackathon.NLP.Models.Article;
import com.hackathon.NLP.Models.Paragraph;
import com.hackathon.NLP.Models.Probabilities;
import com.hackathon.NLP.Requests.StockInfoPost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;


public class MapBuilder {

//    public static void main(String[] s) throws Exception {
//        build();
//    }
    List<String> tickers;

    public Map<String, Probabilities> build() throws Exception {
        Map<String, Probabilities> stocks = new TreeMap<>();;
        StockInfoPost retrievedData = ArticleParser.parse();

            for (int i = 0; i < 10; i++) {
                Article article = retrievedData.articles.get(i);
                TimeUnit.SECONDS.sleep(35);
                Probabilities probability = NLPProcessor.process(article.paragraphs.get(0).text);
                for (String t : article.paragraphs.get(0).ticker) {
                    stocks.put(t, probability);
                    tickers.add(t);
                }

        }
        return stocks;
    }
    public List<String> buildTickers() throws Exception {
        return tickers;
    }

}
