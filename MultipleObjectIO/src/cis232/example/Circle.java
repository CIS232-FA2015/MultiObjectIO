package cis232.example;

import java.io.Serializable;

public class Circle implements Serializable{
	double radius;
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public double getArea(){
		return Math.PI * radius * radius;
	}
}
