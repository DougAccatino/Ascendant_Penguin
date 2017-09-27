package oop;

public class GuineaPig extends Animal{
	
	double tailLength;
	
	public GuineaPig(){
		super();//call parent default constructor
		setHeight(15.2);//practice using inhereted parent method
		tailLength = 1.5;
	}
	
	public void eat(){
		super.eat();//call the parent eat method
		System.out.println("Oink Oink");
	}
	
	public void setTailLength(double tL){
		tailLength = tL;
	}
	
	public double getTailLength(){
		return tailLength;
	}

}