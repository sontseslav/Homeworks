/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0013.translator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class Main {
    static Map<String,String> dict;
    
    public static String getTranslation(String key){
        if (Main.dict.containsKey(key)) return Main.dict.get(key);
        return "";
    }
    
    public static void setTranslation(String fileFrom){
        FileProcessing rff = null;
        try {
            rff = new FileProcessing(fileFrom);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        String s;
        try{
            while ((s = rff.readLineByLine()) != null){
                String[] array = s.split(" ");
                dict.put(array[0], array[1]);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static String setInputText(String fileFrom){
        FileProcessing rff = null;
        StringBuilder sb = new StringBuilder();
        try {
            rff = new FileProcessing(fileFrom);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        String s;
        try{
            while ((s = rff.readLineByLine()) != null){
                sb.append(s).append(" ");
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return sb.toString();
    }
    
    public static void setOutputText(String fileFrom, String translatedTxt){
        FileProcessing rff = null;
        StringBuilder sb = new StringBuilder();
        try {
            rff = new FileProcessing(fileFrom);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try{
            rff.writeAtOnce(translatedTxt);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        dict = new HashMap<>();
        setTranslation("dict.txt");
        String inText = setInputText("in.txt");
        if (inText.contains(".")) inText=inText.replace(".", "");
        if (inText.contains(",")) inText=inText.replace(",", "");
        if (inText.contains("!")) inText=inText.replace("!", "");
        if (inText.contains("?")) inText=inText.replace("?", "");
        if (inText.contains(":")) inText=inText.replace(":", "");
        if (inText.contains(";")) inText=inText.replace(";", "");
        String[] inTextToParse = inText.split(" ");
        
        System.out.printf("Text to translate:%n%s%nOutput:%n",inText);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inTextToParse.length; i++){
            System.out.print(getTranslation(inTextToParse[i]));
            System.out.print(" ");
            sb.append(getTranslation(inTextToParse[i])).append(" ");
        }
        System.out.println();
        setOutputText("out.txt", sb.toString());
    }

}
