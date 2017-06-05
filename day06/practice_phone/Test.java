package practice_phone;

public class Test {

	public static void main(String[] args) {

		Phone op = new OldPhone();
		testPhone(op);

		Phone np = new NewPhone();
		testPhone(np);
	}

	static void testPhone(Phone p) {
		p.sendMessage();
		p.call();
		if (p instanceof IPlay) {
			((IPlay) p).playGame();
		}
	}

}
