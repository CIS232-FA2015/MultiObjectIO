package cis232.example;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MultiUnknownTypeIn {

	public static void main(String[] args) throws IOException{
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("shapes.dat"));
		
		Object o = readObject(input);
		while(o != null){
			if(o instanceof Square){
				Square s = (Square)o;
				System.out.printf("Square area: %.1f%n", s.getArea());
			}else if(o instanceof Rectangle){
				Rectangle r = (Rectangle)o;
				System.out.printf("Rectangle area: %.1f%n", r.getArea());
			} else if(o instanceof Circle){
				Circle c = (Circle)o;
				System.out.printf("Circle area: %.1f%n", c.getArea());
			} 
			
			o = readObject(input);
		}
		
		input.close();

	}
	
	public static Object readObject(ObjectInputStream input){
		Object o = null;
		
		try {
			o = input.readObject();
		} catch (ClassNotFoundException e) {
			// Skip unknown classes
			e.printStackTrace();
		} catch (EOFException e){
			// Skip end of file, this is what we want
		} catch (IOException e) {
			// Silent exceptions...
			e.printStackTrace();
		}
		
		return o;
	}

}
