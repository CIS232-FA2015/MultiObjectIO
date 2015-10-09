package cis232.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MultiUnknownTypeOut {

	public static void main(String[] args) throws IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("shapes.dat"));
		
		output.writeObject(new Circle(10));
		output.writeObject(new Rectangle(5,1));
		output.writeObject(new Square(2));
		
		output.close();
	}

}
