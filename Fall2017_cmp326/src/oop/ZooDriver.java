package oop;

public class ZooDriver {

	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		Animal a3 = new Animal("Australia");
		Animal a4 = new Animal(2,2,175,70,true,"Earth");
		GuineaPig charlotte = new GuineaPig();
		Kangaroo joey = new Kangaroo();
		Hampster jerry = new Hampster();
		Hampster fred = new Hampster();
		Dog shawn = new Dog();
		
/*		a1.speak();
		a2.speak();
		a3.speak();
		a4.speak();
		fred.speak();
		jerry.speak();
		joey.speak();*/
		
		Animal[] animals = { a1,a2,a3,a4,fred,jerry,joey,shawn };
		for(int i = 0; i < 6; i++) {
			animals[i].speak();
		}



		System.out.println(fred);
		
		System.out.println("Jerry");
		System.out.println("EQUALITY STATUS " + fred.equals(jerry));
		jerry.setTailLength(3);
		System.out.println("EQUALITY STATUS AFTER " + fred.equals(jerry) + "\n\n");
		
		a1.setContinentFound("North America");
		a1.setHeight(240.5);
		a1.setWeight(207);
		a1.setNumEars(2);
		
		//a1.setNumLegs(8);
		//a1.setHasFur(false);
		
		a1.eat();
		a2.eat();
		charlotte.eat();
		joey.eat();

		System.out.println("A1: "+a1.toString());
		System.out.println("A2: "+a2.toString());
		System.out.println("A3: "+a3.toString());
		fred.setHasFur(false);
		//cannot compare address location matches
		System.out.println("fred " + fred.toString());//hampster details are included because we overrided
		System.out.println("a4 " +a4.toString());
		
		
		System.out.println("\n\nBEFORE\na1: " + a1.toString());
		
		
		
	}

}