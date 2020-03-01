package com.hackathon.NLP.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.NLP.Models.Article;
import com.hackathon.NLP.Models.Paragraph;
import com.hackathon.NLP.Requests.StockInfoPost;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import static java.lang.System.exit;

public class ArticleParser {

    public static void main(String[] argc) throws IOException, ParseException {
        System.out.println(parse().articles.get(0).paragraphs.get(0).text);

        //DONE
    }

    static StockInfoPost parse() throws IOException, ParseException {
        Reader reader = new FileReader("Resources/articles.json");
        JSONParser parser = new JSONParser();

        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray msg = (JSONArray) jsonObject.get("articles");


        StockInfoPost info = new StockInfoPost();
        for (Object s : msg) {
            JSONObject subJsonObject = (JSONObject) parser.parse(s.toString());

            Article newArticle = new Article();
            newArticle.url = (String) subJsonObject.get("url");
            newArticle.headline = subJsonObject.get("headline").toString();
            JSONArray tickers = (JSONArray) subJsonObject.get("tickers");
            for (Object ticker : tickers) {
                newArticle.tickers.add(ticker.toString());
            }
            newArticle.weight = ((Number) subJsonObject.get("weight")).intValue();
            newArticle.webpage_text = (String) subJsonObject.get("text");
            JSONArray paragraphs = (JSONArray) subJsonObject.get("paragraphs");

            for (Object paragraph : paragraphs) {
                JSONObject paraJsonObject = (JSONObject) parser.parse(s.toString());
                newArticle.paragraphs.add(new Paragraph() {{
                    text = paraJsonObject.get("text").toString();
                    JSONArray paratickers = (JSONArray) paraJsonObject.get("tickers");
                    for (Object paragraph : paratickers) {
                        ticker.add(paragraph.toString());
                    }
                }});
            }

            info.articles.add(newArticle);
        }

        JSONArray tickerTop = (JSONArray) jsonObject.get("all_tickers");
        for (Object o : tickerTop) {
            info.all_tickers.add(o.toString());
        }

        return info;
    }
}
