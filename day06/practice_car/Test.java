package practice_car;

public class Test {
	
	public static void main(String[] args) {
		Car nc = new NormalCar();
		testCar(nc);
		
		Car sc  = new SuperCar();
		testCar(sc);
	}
	
	static void testCar(Car c){
		c.run();
		if(c instanceof Car_technology){
			((Car_technology) c).autoStop();
			((Car_technology) c).autoStop();
		}
	}

}
