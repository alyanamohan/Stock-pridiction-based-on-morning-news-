package com.hackathon.NLP.Models;

public class Probabilities {
    public float negative;
    public float neutral;
    public float positive;
    public Probabilities(){
        this.negative = 0;
        this.positive = 0;
        this.neutral = 0;
    }

    public Probabilities(float positive, float neutral, float negative){
        this.negative = negative;
        this.positive = positive;
        this.neutral = neutral;
    }
}
