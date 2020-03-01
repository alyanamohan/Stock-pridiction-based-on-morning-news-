package com.hackathon.NLP.Processor;

import com.hackathon.NLP.Models.Probabilities;

import java.util.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        ArrayList<String> x = drive();
        for(String r : x){
            System.out.println(r);
        }
    }
    public static ArrayList<String> drive() throws Exception {
        Map<String, Probabilities> probabilitiesMap = (new MapBuilder().build());
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
}
