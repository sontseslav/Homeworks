/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0013.shapes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author user
 */
public class SaveToFile {
    private byte[] buffer;
    private String filename;

    public SaveToFile(String inStr, String filename) {
        this.buffer = inStr.getBytes();
        this.filename = filename;
    }
    
    public void doSave() throws IOException, FileNotFoundException{
        try(OutputStream os = new FileOutputStream(filename)){
            os.write(buffer);
            os.flush();
        }
    }
}
