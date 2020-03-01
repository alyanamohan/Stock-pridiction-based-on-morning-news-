package com.hackathon.NLP.Requests;

import com.hackathon.NLP.Models.Article;

import java.util.ArrayList;

/*
*
* class Article:

    def __init__(self, url, headline, weight, webpage_text="", tickers="", paragraphs=[]):
        self.webpage_text = webpage_text
        self.tickers = tickers
        self.url = url
        self.headline = headline
        self.paragraphs = paragraphs
        self.weight = weight
 */
public class StockInfoPost {
    public ArrayList<String> all_tickers = new ArrayList<>();
    public ArrayList<Article> articles = new ArrayList<>();




}

