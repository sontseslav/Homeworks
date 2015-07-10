package ua.com.iteducate.java.basic.homework.l0015.chatclient;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Message implements Serializable {
	private static final long serialVersionUID = 2L;
	
	public Date date = new Date();
	public String from;
	public String to;
	public boolean isFile;
	byte[] buffer;
	public transient String text;
	public transient String path;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(String path){
		this.path = path;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append("[")
			.append(date.toString())
			.append(", From: ")
			.append(from)
			.append(", To: ")
			.append(to)
			.append("] ")
			.append(text)
			.toString();
	}
	
	public void writeToStream(OutputStream out)
		throws IOException
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bs);
		try {
			os.writeObject(this);
			
			if ( ! isFile) {
				os.writeUTF(text);
			} else {
				File file = new File(path);
				if (!file.exists() && file.length() > 4294967295L){
					System.out.println("File does not exist or too big");//write it to output
					return;
				}
				long size = file.length();
				file = null;
				InputStream inFile = new FileInputStream(path);
				buffer = new byte[(int)size];
				inFile.read(buffer);
				os.write(buffer);
				inFile.close();
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}finally {
			os.flush();
			os.close();
		}
		
		byte[] packet = bs.toByteArray();
		
		DataOutputStream ds = new DataOutputStream(out);
		ds.writeInt(packet.length);
		ds.write(packet);
		ds.flush();//if closed - connection will be interrupted
	}
	
	public static Message readFromStream(InputStream in) 
		throws IOException, ClassNotFoundException
	{
		if (in.available() <= 0)
			return null;
		
		DataInputStream ds = new DataInputStream(in);
		int len = ds.readInt();
		byte[] packet = new byte[len];
		ds.read(packet);
		
		ByteArrayInputStream bs = new ByteArrayInputStream(packet);
		ObjectInputStream os = new ObjectInputStream(bs);
		Message msg = null;
		try {
			msg = (Message) os.readObject();
			if ( ! msg.isFile) {
				msg.text = (String) os.readUTF();
			} else {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter filename to save:");
				String path = scan.next();
				File out = new File(path);
				OutputStream outFile = new FileOutputStream(out);
				outFile.write(msg.buffer);
				outFile.flush();
				outFile.close();
				scan.close();
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}finally {
			os.close();
			return msg; 
		}
	}
}
