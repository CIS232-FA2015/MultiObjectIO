package cis232.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MultiObjectIn {

	public static void main(String[] args) throws IOException{
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("first.rects"));
		
		ArrayList<Rectangle> rects = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			try {
				Rectangle r = (Rectangle)input.readObject();
				rects.add(r);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		input.close();
		
		//Output the area of each rectangle
		for(Rectangle rect : rects){
			System.out.printf("Rectangle area: %.1f%n", rect.getArea());
		}
	}

}
