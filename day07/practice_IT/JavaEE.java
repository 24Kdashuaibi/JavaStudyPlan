package practice_IT;

public class JavaEE extends Developer {
	//�вι���
	public JavaEE(String id, String name) {
		
		super(id,name);
	}
	//�޲ι���		
	public JavaEE(){
		super();
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("����Ա����"+this.getName()+" ��������"+this.getId()+"�ҵĹ�������JavaEE����");
	}

}
