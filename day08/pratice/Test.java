package pratice;

public class Test {
	
	public static void main(String[] args) {
		
		//测试玩游戏，匿名内部类
		new IPlay() {
			public void PlayGame() {
				System.out.println("玩游戏");
				
			}
		};
		
	}
	
	
	

}
