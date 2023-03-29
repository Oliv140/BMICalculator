package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){return "index";}


    @PostMapping("/BMI")                                                    //Denne metoed skal håndtere en http-POST-request
    String generateBMI(@ModelAttribute Calculator calculator, Model model){   //Modelattribute betyder at de inputs der sættes en vil blive brugt til felterne i calculator
        double height = calculator.getheight();                               //Her findes værdierne til calculatoren vha. getters
        double weight = calculator.getWeight();
        double bmi = calculator.generateBMI(weight, height);//Her udregnes bmi vha. metoden baseret på de fundne værdier
        String analysis = calculator.analysisOfBMI();
        model.addAttribute("calculatedBMI", bmi); //Her tilføjes den udregnede værdi ved at bruge model.attribute.
        model.addAttribute("analysisOfBMI", analysis);
        return "index";
    }
    //Her forklares metoden lidt mere uddybbet
    //På første linje indikeres det at metoden skal håndtere et http post request. En POST metode anmoder en webserver om at
    //acceptere noget data.
    //Linje 2, her indikeres det at metoden skal modtage to parametre. En Calculator og en Model.
    //@Modelattribute betyder, at den data der bliver sat ind bliver brugt til at udfylde Calculators attributer.
    //Det betyder at når vores HTML form har to input felter "Height" og "Weight",
    //så vil spring frameworket selv mappe værdierne til de respektive værdier i instansen af vores calculator
    //baseret på navnene fra PostMapping metoden og attributerne i calculator klassen.

}
