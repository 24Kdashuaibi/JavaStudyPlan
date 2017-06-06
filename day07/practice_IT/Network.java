package practice_IT;

public class Network extends Maintainer {

	public Network(String id, String name) {
		// TODO Auto-generated constructor stub
		super(id,name);
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("我是员工："+this.getName()+" ，工号是"+this.getId()+"我的工作是维护Network!!");
	}

}
