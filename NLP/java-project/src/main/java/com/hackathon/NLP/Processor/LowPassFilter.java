package com.hackathon.NLP.Processor;

public class LowPassFilter {
    public static void main(String[] arg){
        double[] temp = {1.0,32.1};
        double[] arr = filter(temp);
        for(int i =0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


    static double[]  filter(double[] toFilter){
        double alpha = 2.0/(toFilter.length+1.0);
        double[] result = new double[toFilter.length];
        ExponentialMovingAverage ema = new ExponentialMovingAverage(alpha);
        for(int i =0; i < toFilter.length; i++)
            result[i] = ema.average(toFilter[i]);
        return result;
    }
}
