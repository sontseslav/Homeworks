package ua.com.iteducate.java.basic.homework.l0015.shapes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

public class Robot  implements Serializable, Cloneable{
    private static final long serialVersionUID = 1L;
    private LinkedList<Shape> shapes = new LinkedList<>();
    private int n = 0;

    public Robot() {

    }

    public void addShapes(String str) throws IdenticalPointsException{
            if (n<=this.shapes.size()){
                    this.shapes.add(0,Shape.parse(str));
            }
            n++;
    }

    public double calsSumS(){
            double sum = 0;
            for(int i = 0;i<n;i++){
                    sum += this.shapes.get(i).calcS();
            }
            return sum;
    }

    public void sortShapesSquare(){
        if (n > 0){
            Collections.sort(shapes);
            for (Shape s:shapes){
                System.out.println(s);
            }
        }
    }

    public void sortShapesPerim(){
        if (n > 0){
            Collections.sort(shapes, new PerimComparator());
            for (Shape s:shapes){
                System.out.println(s);
            }
        }
    }

    public void draw(){
        for (Shape shape : shapes){
            System.out.println(shape.toString());
        }
    }
    
    public static Robot deserialize(InputStream in) throws IOException, ClassNotFoundException{
    	//if (in.available() <= 0) return null;
    	DataInputStream ds = new DataInputStream(in);
    	int length = ds.readInt();
    	byte[] objArray = new byte[length];
    	ds.read(objArray);
    	ByteArrayInputStream bais = new ByteArrayInputStream(objArray);
    	ObjectInputStream ois = new ObjectInputStream(bais);
    	try{
    		Robot robot = (Robot)ois.readObject();
    		return robot;
    	}finally{
    		ois.close();
    	}
    }
    
    public void serialise(OutputStream out) throws IOException{
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	ObjectOutputStream oos = new ObjectOutputStream(baos);
    	try{
    		oos.writeObject(this);
    	}finally{
    		oos.flush();
    		oos.close();
    	}
    	byte[] packet = baos.toByteArray();
    	DataOutputStream dos = new DataOutputStream(out);
    	dos.writeInt(packet.length);
    	dos.write(packet);
    	dos.flush();
    }
}