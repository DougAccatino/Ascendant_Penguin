package oop;

public class Hampster extends Animal {
	
	private double tailLength;
	
	public Hampster(){
		super();//call parent default constructor
		this.setWeight(150);//change grams the hampster weighs
		tailLength = 1.5; //set default values for current class
	}
	//getters and setters go here
	
	public Hampster(double tailLen) {
		super();//calls parent constructor (parent is Animal, hampstter extends animal)
		this.setWeight(150);
		tailLength = tailLen;
	}
	
	public Hampster(double tailLen, int numEars, int nLegs, double ht, double weight, boolean hasFur, String continentFound) {
			super(numEars, nLegs, ht, weight, hasFur, continentFound);//parent overloaded constructor)
			tailLength = tailLen;
	}
	
	public void setTailLength(double tl){
		tailLength = tl;
	}
	
	//getters and setters go here
	public boolean equals(Object o) {
		if(o instanceof Hampster) {
			Hampster otherHampster = (Hampster)o;
			if(super.equals(otherHampster)) {
				if(this.tailLength == otherHampster.tailLength) {
					return true;
				}
			}
		}
		return false;
	}
	
	/* Hampster h = new Hampster(10);
	 * Hampster h = new Hampster();
	 * h.settailLength(10);
	 * 
	 * (non-Javadoc)
	 * @see oop.Animal#eat()
	 */
	
	@Override
	public void eat(){//add to the parent behavior by overriding the inherited method
		super.eat();//include the parent behavior
		System.out.println(" digest, nibble, digest");
	}

@Override
public String toString() {
	String s = super.toString();
	s += "\n\tHampster: Tail Length: "+tailLength;
	return s;
}

/*@Override 
public void speak(s) {
	System.out.println("\t SQUEAK SQUEAK");
}

@Override 
public void speak() {
	System.out.println("\t SQUEAK "+ s );		
}*/


}