package pratice;

public class NewPhone extends Phone implements IPlay {

	@Override
	public void PlayGame() {
		// TODO Auto-generated method stub
		System.out.println("NEWPhone可以打游戏");
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		System.out.println("NEWPhone打电话");
	}

	@Override
	void sendMessage() {
		// TODO Auto-generated method stub
		System.out.println("NEWPhone发短信");
		
	}

}




