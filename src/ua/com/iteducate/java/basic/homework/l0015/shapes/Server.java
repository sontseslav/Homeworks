package ua.com.iteducate.java.basic.homework.l0015.shapes;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port;
	
	public Server(int port){
		this.port = port;
	}
	
	public void start() throws IOException{
		try{
			ServerSocket serv = new ServerSocket(port);
			Socket socket = serv.accept();
			
			InputStream inStream = socket.getInputStream();
			Robot robot = Robot.deserialize(inStream);
			robot.draw();
			serv.close();
			//socket.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	public static void main(String[] args){
		int port = 12345;
		Server server = new Server(port);
		try {
			server.start();
		} catch (IOException e1) {
			System.out.println("Cannot start server");;
			return;
		}
	}
}
