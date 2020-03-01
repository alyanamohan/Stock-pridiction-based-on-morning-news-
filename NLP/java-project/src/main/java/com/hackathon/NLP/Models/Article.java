package com.hackathon.NLP.Models;

import java.util.ArrayList;

public class Article {
    public String webpage_text;
    public ArrayList<String> tickers = new ArrayList<>();
    public String url;
    public String headline;
    public ArrayList<Paragraph> paragraphs = new ArrayList<>();
    public int weight;
}
