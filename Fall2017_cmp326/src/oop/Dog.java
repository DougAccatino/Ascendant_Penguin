package oop;

public class Dog extends Animal{

	private int numArms;
	
	public Dog(){
		super();//call parent default constructor
		setNumLegs(2);
		numArms = 2;
	}
	
	public void eat(){
		super.eat();
		System.out.println("WOOF WOOF...bork..heck");
	}
	
	public void setNumArms(int numArms){
		this.numArms = numArms;
	}
	public int getNumArms(){
		return numArms;
	}
}