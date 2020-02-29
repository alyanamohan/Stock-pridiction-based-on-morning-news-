package com.hackathon.NLP.Processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.NLP.Models.Probabilities;
import com.hackathon.NLP.Models.sentiment;
import com.paralleldots.paralleldots.App;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Hello world!
 */

public class NLPProcessor {
    private static List<Probabilities> parseObjectArray(JSONArray array) {

        List<Probabilities> list = new ArrayList<>();

        for (Object item : array) {
            JSONObject object = (JSONObject) item;
            Probabilities obj = new Probabilities();
            obj.negative = Float.valueOf((String) object.get("negative"));
            obj.neutral = Float.valueOf((String) object.get("neutral"));
            obj.positive = Float.valueOf((String) object.get("positive"));


            list.add(obj);

        }

        return list;
    }
//    private static sentiment parseFooArray(JSONObject obj) {
//
//        List<sentiment> list = new ArrayList<>();
//
//
//            sentiment s = new sentiment();
//            s.probabilities = parseObjectArray( obj.get("Objects"));
//            list.add(s);
//
//        return list;
//    }
    public static void main(String[] arg) throws Exception {
        process("[ \"Come on, lets play together\",\"Team performed well overall\" ]");
    }
    public static void process(String toParse) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        App pd = new App("ysI8xgSI1UTPyLzuv0Wh4qXh4SdXWzAVA3k1xh1NP6I");
        JSONParser parser = new JSONParser();
        JSONArray text_list = (JSONArray)parser.parse(toParse);

        String sentiment_batch = pd.sentiment_batch(text_list);

        sentiment x = mapper.readValue(sentiment_batch, sentiment.class);
        Probabilities[] r = x.sentiment;
        System.out.println(r[0].positive);

        Stock stock = YahooFinance.get("INTC");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

       stock.print();
        System.out.println(r[0].positive);

       /* Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -5); // from 5 years ago

        Stock google = YahooFinance.get("GOOG", from, to, Interval.WEEKLY);

        google.print();*/

    }
}



        
