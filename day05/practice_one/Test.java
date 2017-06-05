package practice_one;



public class Test {
	
	public static void main(String[] args) {
		//测试需求一
		Manager man = new Manager();
		man.id="10001";
		man.name="李白";
		man.salary=99.99;
		man.work();
		
		Programmer pro  =new Programmer();
		pro.id="10086";
		pro.name="杜甫";
		pro.salary=55.55;
		pro.work();
		
		//测试需求二
		Teacher te  = new Teacher();
		te.name="李白老师";
		te.age=22;
		te.eat();
	
		
		Student stu = new Student();
		stu.name="学生杜甫";
		stu.age=12;
		stu.eat();
		
		//测试需求三
		Dog dog = new Dog();
		dog.eat();
		dog.lookHome();
		Cat cat = new Cat();
		cat.eat();
		cat.catchMouse();
		
	}

}
