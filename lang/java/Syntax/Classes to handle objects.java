public class myClass {
	public static void main(String args[]){
		   
		  DogList DGO = new DogList();
		  Dog JackRussel = new Dog();
		  Dog Staff = new Dog();
		  
		  DGO.addDog(JackRussel);
		  DGO.addDog(Staff);
		 
	   }
}


public class Dog extends Animal{

}

public class Fish extends Animal{

}


public class Animal {

}


public class DogList {

	private Dog[] theList = new Dog[5];
	private int i=0;
	
	public void addDog(Dog d){
		if(i<theList.length){
			theList[i] = d;
			System.out.print("Dog added at index: " +i);
			System.out.println();
			i++;
		}
		
	}
}
