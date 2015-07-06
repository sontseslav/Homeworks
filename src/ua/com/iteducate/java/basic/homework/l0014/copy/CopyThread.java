package ua.com.iteducate.java.basic.homework.l0014.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyThread implements Runnable{

	private File filename;
	private FileRW frw;
	
	public CopyThread(File filename, FileRW frw) {
		this.filename = filename;
		this.frw = frw;
	}

	@Override
	public void run() {
		InputStream inFile = null;
		try {
			inFile = new FileInputStream(this.filename);
		} catch (FileNotFoundException e) {
			System.out.printf("File %s not found. Exiting...%n",this.filename);
		}
		File out = new File("out");
		OutputStream outFile = null;
		try {
			outFile = new FileOutputStream(out);
		} catch (FileNotFoundException e1) {
			System.out.println("Output file cannot be created. Exiting;");
		}
		try {
			while(inFile.available()>0){
				inFile.read(frw.getBuffer());
				outFile.write(frw.getBuffer());
				frw.setCounter();
				}
		} catch (IOException e) {}
		
		
		try {
			outFile.flush();
			outFile.close();
			inFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
