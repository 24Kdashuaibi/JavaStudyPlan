package practice_IT;
//员工类，所有员工的父类。
public abstract class Employee {
		private String id;    //工号
		private String name;   //员工姓名
		//无参构造
		public Employee(){
			//初始化父类
			super();
		}
		//有参构造
		public Employee(String id,String name){
			//初始化父类
			super();
			this.id = id;
			this.name =name;
		}
		//抽象工作方法，让子类实现
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
