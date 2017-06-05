package practice_one;

public class Manager extends Employee {
	
		private  double reward=188.00;  //奖金
		
		
		//重写父类方法
		public void work(){
			super.work();
			System.out.println("项目经理奖金："+this.reward);
		}
		
}
