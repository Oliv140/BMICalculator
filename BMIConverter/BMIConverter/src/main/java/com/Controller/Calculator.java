package com.Controller;

public class Calculator {

    private double weight;
    private double height;


    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight=weight;
    }
    public double getheight(){
        return height;
    }
    public void setHeight(double height){
        this.height=height;
    }

    public double generateBMI(double weight, double height){
        return weight/(height*height);
    }

    public String analysisOfBMI(){
        double bmi = generateBMI(weight, height);
            if(bmi<20){
                return "Din Bmi er for lav";
            } else if (bmi>25) {
                return "Din bmi er for høj";
            }
        return "Din BMI er tilpas";
    }


}
