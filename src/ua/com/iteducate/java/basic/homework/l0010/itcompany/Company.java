/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0010.itcompany;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author user
 */
public class Company<E extends Employee> {
    protected static ArrayList<Employee> companyStuff;
//    protected static CEO ceo;
//    protected static CTO cto;
//    protected static BA[] ba;
//    protected static PM[] pm;
//    protected static TL[] tl;
//    protected static SD[] sd;
//    protected static MD[] md;
//    protected static JD[] jd;
    
    private Company(){};
    
    protected static Company hireEmployees() throws Exception{
        FileInputStream file = new FileInputStream("NameBank");
        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        Random rand = new Random();
        for (String line = ""; (br.readLine()) != null;){
            if (line.substring(0, 2).equals("//")){
            }else{
                String[] s = line.split(" ");
                companyStuff.add(new Employee(s[0], s[1], rand.nextInt(10), 
                        rand.nextInt(10000)-rand.nextInt(2000), 
                        rand.nextInt(5)/(rand.nextInt(4)+1)));
            }
        }
        br.close();
        file.close();
        return new Company();
    }
    
    protected E createStuff(){
        E emp = (E) companyStuff.get(companyStuff.size()-1);
        companyStuff.remove(companyStuff.size()-1);
        return emp;
    }
    
}
