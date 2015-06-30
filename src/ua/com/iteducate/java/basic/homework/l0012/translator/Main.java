/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0012.translator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class Main {
    private Map<String,String> dict;

    public Main() {
        this.dict = new HashMap<>();
    }
    
    public void setTranslation(){
        this.dict.put("Priest", "Піп");
        this.dict.put("had", "мав");
        this.dict.put("dog", "собака");
        this.dict.put("and", "і");
        this.dict.put("He", "Він");
        this.dict.put("loved", "любив");
        this.dict.put("her", "її");
        this.dict.put("She", "Вона");
        this.dict.put("ate", "з’їв");
        this.dict.put("piece", "шматок");
        this.dict.put("meat", "м’ясо");
        this.dict.put("killed", "вбив");
        this.dict.put("buried", "закопав");
        this.dict.put("in", "в");
        this.dict.put("ground", "земля");
        this.dict.put("inscription", "напис");
        this.dict.put("written", "написав");
    }
    
    public String getTranslation(String key){
        if (this.dict.containsKey(key)) return this.dict.get(key);
        return "";
    }
    
    public static void main(String[] args) {
        String inText = "Priest had a dog and he loved her. She ate a piece of "
                + "meat and he killed her. He buried her in the ground and "
                + "an inscription written.";
        if (inText.contains(".")) inText=inText.replace(".", "");
        if (inText.contains(",")) inText=inText.replace(",", "");
        if (inText.contains("!")) inText=inText.replace("!", "");
        if (inText.contains("?")) inText=inText.replace("?", "");
        if (inText.contains(":")) inText=inText.replace(":", "");
        if (inText.contains(";")) inText=inText.replace(";", "");
        String[] inTextToParse = inText.split(" ");
        Main m = new Main();
        m.setTranslation();
        System.out.printf("Text to translate:%n%s%nOutput:%n",inText);
        for (int i = 0; i < inTextToParse.length; i++){
            System.out.print(m.getTranslation(inTextToParse[i]));
            System.out.print(" ");
        }
    }
}
