package oop;

public class Kangaroo extends Animal{

	private int numArms;
	
	public Kangaroo(){
		super();//call parent default constructor
		setNumLegs(2);
		numArms = 2;
	}
	
	public void eat(){
		super.eat();
		System.out.println("JUMPING while eating .. don't choke");
	}
	
	public void setNumArms(int numArms){
		this.numArms = numArms;
	}
	public int getNumArms(){
		return numArms;
	}
}