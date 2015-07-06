package ua.com.iteducate.java.basic.homework.l0014.copy;

public class OutputThread implements Runnable{

	private FileRW frw;
	
	public OutputThread(FileRW frw) {
		this.frw = frw;
	}

	@Override
	public void run() {
		while (frw.getCounter().get() < 100){
			System.out.printf("%d percent completed...%n",frw.getCounter().get());
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
		}
		System.out.println("Completed");
	}
	
}
