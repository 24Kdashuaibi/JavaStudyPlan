package practice_IT;

public class JavaEE extends Developer {
	//有参构造
	public JavaEE(String id, String name) {
		
		super(id,name);
	}
	//无参构造		
	public JavaEE(){
		super();
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("我是员工："+this.getName()+" ，工号是"+this.getId()+"我的工作是做JavaEE开发");
	}

}
