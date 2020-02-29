package Responses;

public class StockResponse {
    public String ticker;
    public String companyName;
    public String articleURL;
    public int articleWeight;
    public double confidenceScore;

    public StockResponse(String ticker, String companyName, String articleURL, int articleWeight, double confidenceScore) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.articleURL = articleURL;
        this.articleWeight = articleWeight;
        this.confidenceScore = confidenceScore;
    }





}
