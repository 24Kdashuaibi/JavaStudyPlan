package practice_IT;

public class Hardware extends Maintainer {

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("我是员工："+this.getName()+" ，工号是"+this.getId()+"我的工作是维护Hardware");
	}

}
