package practice_IT;
//Ա���࣬����Ա���ĸ��ࡣ
public abstract class Employee {
		private String id;    //����
		private String name;   //Ա������
		//�޲ι���
		public Employee(){
			//��ʼ������
			super();
		}
		//�вι���
		public Employee(String id,String name){
			//��ʼ������
			super();
			this.id = id;
			this.name =name;
		}
		//������������������ʵ��
		public abstract void work();
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
}
