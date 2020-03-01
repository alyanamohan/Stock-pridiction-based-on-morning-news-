package com.hackathon.NLP.Endpoints;

import com.hackathon.NLP.Processor.Driver;
import com.hackathon.NLP.Responses.StockResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import static spark.Spark.*;




public class GetStockInfo {

    static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args){
        port(8080);
        StockResponse test = new StockResponse("test1","test2","test3",1,.5);
        try {
            get("/GetStockInfo", (req, res) -> {
                return objectMapper.writeValueAsString((new Driver().drive()));
            });

        }
        catch(Exception e){
//            e.getStackTrace();
            get("/GetStockInfo", (req, res) -> "Failed parsing Json");
        }
    }
}
