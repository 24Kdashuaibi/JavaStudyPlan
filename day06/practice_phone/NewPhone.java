package practice_phone;

public class NewPhone extends Phone implements IPlay{

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("NewPhone can playGame");
		
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		System.out.println("NewPhone call ");
	}

	@Override
	void sendMessage() {
		// TODO Auto-generated method stub
		System.out.println("NewPhone sendMessage");
	}

}
