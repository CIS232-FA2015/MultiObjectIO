package cis232.example;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class UnknownNumberOfObjectsIn {

	public static void main(String[] args) throws IOException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(
				"first.rects"));

		ArrayList<Rectangle> rects = new ArrayList<>();

		Rectangle r = readRectangle(input);
		while(r != null){
			rects.add(r);
			r = readRectangle(input);
		}
		
		input.close();

		// Output the area of each rectangle
		for (Rectangle rect : rects) {
			System.out.printf("Rectangle area: %.1f%n", rect.getArea());
		}
	}
	
	public static Rectangle readRectangle(ObjectInputStream input){
		Rectangle r = null;
		
		try {
			r = (Rectangle) input.readObject();
		} catch (ClassNotFoundException e) {
			// Skip unknown classes
		} catch (EOFException e){
			// Skip end of file, this is what we want
		} catch (IOException e) {
			// Silent exceptions...
		}
		
		return r;
	}
}
