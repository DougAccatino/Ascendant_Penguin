package oop;


public class Animal implements Survivor, Communicator{
	
	private static int numOfAnimals = 0;
	//instance variables, member variables, attributes
	private int animalNum;
	private int numLegs;
	private int numEars;
	private double height;
	private double weight;
	private boolean hasFur;
	private String continentFound;
	private Face face; //use our Face class 
	
	public Animal(){//default constructor
		numLegs = 4;
		numEars = 2;
		height = 0; //0.0
		weight = 0; //0.0
		hasFur = true;
		continentFound = "TBD";
		face = new Face();
		//want to increment counter eventually
	}
	public int getAnimalNum(){
		return animalNum;
	}
	
	public static int getNumOfAnimals() {
		return numOfAnimals;
	}

	public Animal(String continentFound) {//overloaded constructor
		this();//call this class's constructor to assign default values
		this.continentFound = continentFound;
	}
	//cant have two overloaded constructors of the same type (int,int, or double,double)
	//with another constructor as (int,int or double,double)
	public Animal(int numEars, int nLegs) {
		this();//default constructor
		this.numEars = numEars;
		numLegs = nLegs;
	}
	
	public Animal(double height, double wt) {
		this();
		this.height = height;
		weight = wt;
	}
	//setting variables as theyre being called in.
	public Animal(int numEars, int nLegs, double height, double wt, boolean hasFur, String continentFound) {
		numLegs = nLegs;
		this.numEars = numEars;
		this.height = height;
		this.weight = wt;
		this.hasFur = hasFur;
		this.continentFound = continentFound;
		face = new Face();
	}
	//can have overloaded constructor with Face also being passed in
	//int double short long char are primitives and can use ==

	@Override
	public boolean equals(Object o) {
		if(o instanceof Animal)            {//check that o is an Animal
			Animal otherAnimal = (Animal) o;	//cast Animal to be able to check attributes
			if(this.numEars == otherAnimal.numEars) {
				if(this.numLegs == otherAnimal.numLegs) {
					if(this.height == otherAnimal.height) {
						if(this.weight == otherAnimal.weight) {
							if(this.hasFur == otherAnimal.hasFur) {
								if(this.continentFound.equalsIgnoreCase(otherAnimal.continentFound)) {
									
									return true; //all matched for equality so match returns true
									
																	}
																}
															}
														}
													}
												}
											}
		//logic
			return false;
								    }
	
			public int compareTo(Object o) {
				if(o instanceof Animal) {//check that o is an animal
					Animal otherAnimal = (Animal) o; //cast to Animal to be able to check attributes
					if(this.height < otherAnimal.height) {
						return -1; //this animal is shorter than the other
					}
					else if(this.height > otherAnimal.height) {
						return 1; //this animal is taller than the other
					}
					else {
						return 0; //same height
					}	
				}
				return -1; //our's is always lesser if the other isn't even an Animal
			}
			

	
	
/*	public boolean equals(Object o) {
			if(o instanceof Animal) {
				Animal otherAnimal = (Animal) o;
				if(		(this.numEars == otherAnimal.numEars) && (this.numLegs == otherAnimal.numLegs) &&
						(this.numLegs == otherAnimal.numLegs) && (this.height == otherAnimal.height)    &&
						(this.weight == otherAnimal.weight)   && (this.hasFur == otherAnimal.hasFur)   &&
						(this.continentFound.equalsIgnoreCase(otherAnimal.continentFound))) {
							return true; //compares equality with AND statements
						}
			}
		}
*/
	
	
	//toString method lovely for avoiding retyping nonsense to find info about your object

	@Override
	public String toString() {
		String s = "\nAnimal" +		
		        " Ears: " + numEars +
				" \nLegs: " + numLegs +
				" \nHeight: " + height +
				" \nWeight: " + weight +
				" \nContinent: " + continentFound + "," +
				" \nFace: " + face;
				if(hasFur) {
					s += "\n\t\t\thas fur\n";
				}
				else {
					s += "\n\t\t\tdoes not have fur\n";
				}
				
				s+= face;
				
		return s;
		
	}
	
	public void eat(){//behavior
		System.out.print("\nChomp Chomp ");
	}
	//getters or accessor, setters or modifier
	public void setHeight(double height){
		if(height > 0){
			this.height = height; 
		}
	}
	public double getHeight(){
		return height; //this.height
	}

	public static void setNumOfAnimals(int numOfAnimals) {
		Animal.numOfAnimals = numOfAnimals;
	}

	public int getNumLegs() {
		return numLegs;
	}

	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}

	public int getNumEars() {
		return numEars;
	}

	public void setNumEars(int numEars) {
		this.numEars = numEars;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean getHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	public String getContinentFound() {
		return continentFound;
	}

	public void setContinentFound(String continentFound) {
		this.continentFound = continentFound;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}
	

@Override
public void sleep() {
	System.out.println("ZZZ ZZZ ZZ");
}

@Override
public void drink() {
	System.out.println("Gulp Gulp");
}

@Override
public void speak() {
	System.out.println("I AM SPEAKING as an Animal");
}

@Override
public void speak(String s) {
	
}
@Override
public void eat(String n) {
	// TODO Auto-generated method stub
	
}
}