package practice_animal;

public class Test {
	public static void main(String[] args) {
		
		Animal dog = new Dog();
		Animal cat  =new Cat();
		testAnimal(dog);
		testAnimal(cat);
		
	}
	
	public static void testAnimal(Animal a){
		a.eat();
		if(a instanceof Dog){
			((Dog) a).lookHome();
		}
		if(a instanceof Cat){
			((Cat) a).catchMouse();
		}
	}

}
