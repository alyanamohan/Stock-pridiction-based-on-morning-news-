package com.hackathon.NLP.Processor;

import com.hackathon.NLP.Models.Probabilities;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static oracle.jrockit.jfr.events.Bits.doubleValue;

public class Driver {
    public static void main(String[] args) throws Exception {
        ArrayList<String> x = drive();
        for(String r : x){
            System.out.println(r);
        }
    }
    public static ArrayList<String> drive() throws Exception {
        Map<String, Probabilities> probabilitiesMap = (new MapBuilder().build());
        List<String> tickers = (new MapBuilder().buildTickers());


        List<Map.Entry<String, Probabilities>> list =
                new LinkedList<Map.Entry<String, Probabilities>>(probabilitiesMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Probabilities>>() {
            public int compare(Map.Entry<String, Probabilities> o1,
                               Map.Entry<String, Probabilities> o2) {
                float sum = o1.getValue().positive - o2.getValue().positive;
                if(sum == 0)
                {
                    return 0;
                }
                else if(sum < 0)
                    return -1;
                else
                    return 1;
            }
        });
        Map<String, Probabilities> sortedMap = new LinkedHashMap<String, Probabilities>();
        for (Map.Entry<String, Probabilities> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
       return new ArrayList<String>(sortedMap.keySet());
    }

    public static String getVibration(String ticker) throws IOException {
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -5); // from 5 years ago

        Stock stock = YahooFinance.get(ticker, from, to, Interval.WEEKLY);;
        List<HistoricalQuote> stockPrices = stock.getHistory(from, to, Interval.WEEKLY);

        double[][] quarterlyAmplitudes = new double[16][16];
        double fiveYearPrices[] = new double[256];

        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                quarterlyAmplitudes[i][j] = doubleValue((stockPrices.get(i * 16 + j)).getClose());
            }
        }

        for(int i = 0; i < 256; ++i){
            fiveYearPrices[i] = doubleValue(stockPrices.get(i).getClose());
        }
        /*for(int j = 0; j < fiveYearPrices.length; ++j){
            System.out.println("Price: " + fiveYearPrices[j]);
            fiveYearDoubles[j] = doubleValue(fiveYearPrices[j]);
        }*/
        double[] frequencies = new double[16];
        for(int k = 0; k < 16; k++) {
            FFTbase model = new FFTbase();
            //double fftSize = Math.floor(Math.log())
            double[] imagin = new double[16];
            for (double elem : imagin) {
                elem = 0;
            }
            double[] fftArr;
            fftArr = model.fft(quarterlyAmplitudes[k], imagin, true);
            assert fftArr != null;
            LowPassFilter LPF = new LowPassFilter();
            double[] filteredArr;
            filteredArr = LPF.filter(fftArr);
            Double finalVals[] = new Double[16];
            for (int l = 0; l < 32; l++) {
                filteredArr[l] = filteredArr[l] + filteredArr[++l];
            }
            int n = 0;
            for (int m = 0; m < 32; m++) {
                if (m % 2 == 0) {
                    finalVals[n] = filteredArr[m];
                    n++;
                }
            }
            frequencies[k] = (double) Collections.max(Arrays.asList(finalVals));
        }


            double xArr[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            double yArr[] = frequencies;

            double xSum = 0, ySum = 0, xySum = 0;
            double squareX = 0, squareY = 0;

            for (int i = 0; i < 16; i++)
            {
                xSum = xSum + xArr[i];
                ySum = ySum + yArr[i];
                xySum = xySum + xArr[i] * yArr[i];
                squareX = squareX + xArr[i] * xArr[i];
                squareY = squareY + yArr[i] * yArr[i];
            }
            double corr = (float)(16 * xySum - xSum * ySum)
                    / Math.sqrt((16 * squareX - xSum * xSum)
                    * (16 * squareY - ySum * ySum));
            if(corr < 0.9)
                return "FORCE VIBRATION";
            return "FREE VIBRATION";


    }


}



