package practice_one;

public class Manager extends Employee {
	
		private  double reward=188.00;  //����
		
		
		//��д���෽��
		public void work(){
			super.work();
			System.out.println("��Ŀ������"+this.reward);
		}
		
}
