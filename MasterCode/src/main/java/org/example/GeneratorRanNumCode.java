package org.example;

import java.util.Random;

public class GeneratorRanNumCode {

    private final Random choseRandNum;
    
    public GeneratorRanNumCode(){
        this.choseRandNum = new Random();
    }
    public GeneratorRanNumCode(Random random){
        this.choseRandNum = random;
    }


    public String generateCode(){

        StringBuilder code =  new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int randomNumber = (this.choseRandNum.nextInt(8) + 1);
            if(!code.toString().contains(String.valueOf(randomNumber))){
                code.append(randomNumber);
            }
            else {
                i--;
            }
        }

        return code.toString();
    }
}