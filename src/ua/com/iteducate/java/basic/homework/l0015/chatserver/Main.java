package ua.com.iteducate.java.basic.homework.l0015.chatserver;
import java.io.*;
import java.net.*;
public class Main {
	public static void main(String[] args) throws Exception {

		Server s = new Server(5000);
		s.start();
	}
}
