package practice_car;

public class SuperCar extends Car implements Car_technology {

	@Override
	public void autoStop() {
		// TODO Auto-generated method stub
		System.out.println("superCar can autoStop");
	}

	@Override
	public void autoDrive() {
		// TODO Auto-generated method stub
		System.out.println("superCar can autoDrive");
	}

}
