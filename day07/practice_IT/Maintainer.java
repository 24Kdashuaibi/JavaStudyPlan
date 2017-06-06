package practice_IT;
//维护类员工
public abstract class Maintainer extends Employee {
		//无参构造
		public Maintainer(){
			super();
		}
		
		//有参构造
		public Maintainer(String id,String name){
			super(id,name);
		}
}
