package practice_one;



public class Test {
	
	public static void main(String[] args) {
		//��������һ
		Manager man = new Manager();
		man.id="10001";
		man.name="���";
		man.salary=99.99;
		man.work();
		
		Programmer pro  =new Programmer();
		pro.id="10086";
		pro.name="�Ÿ�";
		pro.salary=55.55;
		pro.work();
		
		//���������
		Teacher te  = new Teacher();
		te.name="�����ʦ";
		te.age=22;
		te.eat();
	
		
		Student stu = new Student();
		stu.name="ѧ���Ÿ�";
		stu.age=12;
		stu.eat();
		
		//����������
		Dog dog = new Dog();
		dog.eat();
		dog.lookHome();
		Cat cat = new Cat();
		cat.eat();
		cat.catchMouse();
		
	}

}
