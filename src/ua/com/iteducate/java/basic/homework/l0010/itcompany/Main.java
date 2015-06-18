/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0010.itcompany;


/**
 *
 * @author user
 */
public class Main {
    static    CEO ceo = null; 
    static    CTO cto = null;
    static    BA[] ba = new BA[2];
    static    PM[] pm = new PM[4];
    static    TL[] tl = new TL[4];
    static    SD[] sd = new SD[12];
    static    MD[] md = new MD[25];
    static    JD[] jd = new JD[40];
    
    public static void main(String[] args) {

        //create instances of different types
        //pretty stupid algorithm
        ceo = Employee.createEmployee("", "", 10, 5000, 5);
        cto = Employee.createEmployee("", "", 10, 4750, 4.5);
        for (int i = 0;i < ba.length;i++){
            ba[i] = Employee.createEmployee("", "", 5, 4500, 4);
        }
        for (int i = 0;i < pm.length;i++){
            pm[i] = Employee.createEmployee("", "", 4, 4000, 4);
        }
        for (int i = 0;i < tl.length;i++){
            tl[i] = Employee.createEmployee("", "", 4, 3750, 4);
        }
        for (int i = 0;i < sd.length;i++){
            sd[i] = Employee.createEmployee("", "", 5, 3500, 4);
        }
        for (int i = 0;i < ba.length;i++){
            md[i] = Employee.createEmployee("", "", 5, 4500, 4);
        }
        for (int i = 0;i < jd.length;i++){
            jd[i] = Employee.createEmployee("", "", 5, 4500, 4);
        }
    
    }
}
