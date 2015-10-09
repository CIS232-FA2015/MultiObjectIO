package cis232.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MultiObjectOut {
	
	public static void main(String[] args) throws IOException{
		ArrayList<Rectangle> rects = new ArrayList<>();
		
		rects.add(new Rectangle(4,3));
		rects.add(new Rectangle(6,6));
		rects.add(new Rectangle(3,10));
		rects.add(new Rectangle(7,10));
		rects.add(new Rectangle(3,11));
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("first.rects"));
		
		for(Rectangle r : rects){
			output.writeObject(r);
		}
		
		output.close();
	}
}
