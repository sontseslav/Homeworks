/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0013.shapes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author user
 */
public class SaveToObject{
    private Robot robot;
    private String filename;

    public SaveToObject(Robot robot, String filename) {
        this.robot = robot;
        this.filename = filename;
    }
    
    public void doSave() throws IOException, FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(filename);
        try(ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(robot);
            oos.flush();
        }
    }
}
