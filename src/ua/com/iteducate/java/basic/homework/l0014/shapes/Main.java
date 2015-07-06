package ua.com.iteducate.java.basic.homework.l0014.shapes;

public class Main {

	public static void main(String[] args) {
		Robot rb = new Robot();
		OutputThread output = new OutputThread(rb);
                Thread outThread = new Thread(output,"OutputThread");
                InputThread input = new InputThread(rb, outThread);
		Thread inThread = new Thread(input,"InputThread");
                inThread.start();
                outThread.start();
		
	}

}
