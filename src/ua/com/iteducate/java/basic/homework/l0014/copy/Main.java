package ua.com.iteducate.java.basic.homework.l0014.copy;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File inFile = new File("in");
		if (inFile.exists() && inFile.length() < 4294967295L){
			int bytesToProcess = (int)inFile.length()/100;//bytes in 1%
			FileRW frw = new FileRW(bytesToProcess);
			CopyThread ct = new CopyThread(inFile, frw);
			Thread tIn = new Thread(ct);
			OutputThread ot = new OutputThread(frw);
			Thread tOut = new Thread(ot);
			tIn.start();
			tOut.start();
		}else System.out.println("Input file does not exist or has too big size (more than 3GB)");

	}

}
