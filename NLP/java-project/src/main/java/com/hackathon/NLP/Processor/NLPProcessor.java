package com.hackathon.NLP.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.NLP.Models.Probabilities;
import com.hackathon.NLP.Models.sentiment;
import com.paralleldots.paralleldots.App;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
/*
 at [Source: (String)"{"sentiment":[{"negative":0.245,"neutral":0.348,"positive":0.407},{"negative":0.891,"neutral":0.076,"positive":0.033},{"negative":0.796,"neutral":0.157,"positive":0.047},{"negative":0.825,"neutral":0.106,"positive":0.069},{"negative":0.76,"neutral":0.138,"positive":0.102},{"negative":0.045,"neutral":0.516,"positive":0.439},{"negative":0.009,"neutral":0.396,"positive":0.595},{"negative":0.872,"neutral":0.098,"positive":0.03},{"negative":0.085,"neutral":0.413,"positive":0.502},{"negative":0.622,"n"[truncated 3242 chars]; line: 1, column: 854] (through reference chain: com.hackathon.NLP.Models.sentiment["sentiment"]->java.lang.Object[][16]->com.hackathon.NLP.Models.Probabilities["code"])

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
        Probabilities p = process("Businesses across the globe are feeling the crunch after this week's stock market bloodbath.Global markets plummeted this week as fear over the potential impact of the coronavirus outbreak gripped investors. The Dow Jones Industrial Average lost 14%, the S&P lost 13% after falling from a record high just last week, and U.S. Treasury bond yields plummeted to new record lows as traders abandoned risky assets for safer ones.Investors also had to contend with mixed messages: while President Trump appeared to downplay the crisis, the CDC warned that the American public should brace for major disruptions, saying that the spread of the disease in the United States is “not so much a question of if this will happen anymore, but rather more of a question of exactly when this will happen.\" The Federal Reserve even weighed in on Friday, with Chair Jerome Powell releasing a statement pledging to “use our tools and act as appropriate” to help mitigate the effects of the crisis. More than 81,000 people have been infected with the coronavirus so far, and businesses across the globe are feeling the crunch even as Chinese workers return to their jobs. As investors head into what is sure to be an uneasy weekend, take a look at some of the big numbers that defined the market’s worst week since the depths of the financial crisis. According to data from S&P and Dow Jones Indices, global markets have now lost $6 trillion in value since the beginning of the selloff on Friday, $4 trillion of which came from losses in U.S. markets.The S&P 500 Index dropped 12% from a record high to a full-blown correction in just 6 days’ time. To reach bear market territory, it will need to drop at least 20% from that high. The last time the S&P dropped this quickly was in 1933 at the start of the Great Depression, when the index lost 13.3% in just two days, according to the Financial Times. PROMOTEDGoldman Sachs is now predicting that U.S. companies will generate no earnings growth at all in 2020 as a result of the coronavirus outbreak.Tech giant Microsoft’s market cap ballooned to an all-time high of $1.435 trillion on February 10th. After this week, that market value has shed $229 billion.The VIX index, which measures market volatility and is used as a gauge for investor fear, reached 42.24 at the close of markets on Friday afternoon.That’s almost three times higher than its level at the beginning of the month. Volatility levels haven’t been this high since 2011. The yield on a 10-Year U.S. Treasury bond plunged to 1.14% on Friday, a new record low to cap off a week of record lows, as investors continued to flee risky assets.Bond traders are confident the Fed will take action: they say a 0.25% rate cut is 100% likely to happen.As of Friday, at least 54 countries had reported confirmed cases of the coronavirus. The majority of cases are in China, while South Korea has the second-largest concentration of cases.Despite this week’s blockbuster losses, the S&P 500 is still holding on to some long-term gains: it’s up 5% from where it was on this day last year.\n");
        System.out.println(p.positive);
//        double[] arr = {-0.03480425839330703,0.07910192950176387,0.7233322451735928,0.1659819820667019};
//        double[] arr2 = {0.0,0.0,0.0,0.0};
//        double[] answer = new FFTbase().fft(arr,arr2, true);
//
//        for(int i =0; i < answer.length; i++){
//            System.out.println(answer[i]);
//        }
    }

    public static Probabilities process(String toParse) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        App pd = new App("ylyQhvkEe5A99NJPfBuxrx4zz3arwnfo1YLL3esGCws");
        JSONParser parser = new JSONParser();
        String[] parsedString = toParse.split("(?<=[a-z])\\.\\s+");
        JSONArray jsArray = new JSONArray();
        jsArray.addAll(Arrays.asList(parsedString));
        Probabilities overAll = new Probabilities(0, 0, 0);
        String sentiment_batch = pd.sentiment_batch(jsArray);
        System.out.println(sentiment_batch);

        JSONArray sentiment = (JSONArray) ((JSONObject) parser.parse(sentiment_batch)).get("sentiment");

        for (Object o : sentiment) {
            JSONObject subParse = (JSONObject) parser.parse(o.toString());
            overAll.positive += ((Number) subParse.get("positive")).floatValue();
            overAll.neutral += ((Number) subParse.get("neutral")).floatValue();
            overAll.negative += ((Number) subParse.get("negative")).floatValue();
        }


//        overAll.probabilities.positive =  0;
//        overAll.probabilities.neutral =  0;
//        overAll.probabilities.negative = 0;

        return overAll;


//        JSONArray text_list = (JSONArray)parser.parse(toParse);


//        String sentiment_batch = pd.sentiment_batch(text_list);
//
//        sentiment x = mapper.readValue(sentiment_batch, sentiment.class);
//        Probabilities[] r = x.sentiment;
//        System.out.println(r[0].positive);
//
//        Stock stock = YahooFinance.get("INTC");
//
//        BigDecimal price = stock.getQuote().getPrice();
//        BigDecimal change = stock.getQuote().getChangeInPercent();
//        BigDecimal peg = stock.getStats().getPeg();
//        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
//
//       stock.print();
//        System.out.println(r[0].positive);

       /* Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -5); // from 5 years ago

        Stock google = YahooFinance.get("GOOG", from, to, Interval.WEEKLY);

        google.print();*/

    }
}



        
