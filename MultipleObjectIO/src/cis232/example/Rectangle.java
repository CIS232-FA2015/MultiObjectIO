package cis232.example;

import java.io.Serializable;

public class Rectangle implements Serializable{
	double length;
	double width;
	
	public Rectangle(double length, double width){
		this.length = length;
		this.width = width;
	}
	
	public double getArea(){
		return length * width;
	}
}
