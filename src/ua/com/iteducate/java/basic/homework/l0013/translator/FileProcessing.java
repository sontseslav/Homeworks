/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0013.translator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author user
 */
public class FileProcessing {
    private String filename;
    private BufferedReader bufRead;

    public FileProcessing(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.bufRead = new BufferedReader(new FileReader(this.filename));
    }
    
    public String readLineByLine() throws IOException{
        return bufRead.readLine();
    }
    
    public void writeAtOnce(String outStr) throws IOException{
        bufRead = null;
        byte[] buff = outStr.getBytes();
        try (OutputStream os = new FileOutputStream(filename)){
            os.write(buff);
            os.flush();
        }
    }
}
