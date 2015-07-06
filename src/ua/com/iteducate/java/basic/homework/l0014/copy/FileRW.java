package ua.com.iteducate.java.basic.homework.l0014.copy;

import java.util.concurrent.atomic.AtomicInteger;

public class FileRW {
	private volatile byte[] buffer;
	private AtomicInteger counter;

	public FileRW(int size) {
		this.buffer = new byte[size];//1%
		this.counter = new AtomicInteger(0);
}

	public byte[] getBuffer() {
		return buffer;
	}
	
	public AtomicInteger getCounter() {
		return this.counter;
	}

	public void setCounter() {
		this.counter.getAndIncrement();
	}
	
}
