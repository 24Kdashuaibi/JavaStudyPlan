package practice_two;

public class Test {
	
	public static void main(String[] args) {
		//测试老师
		ChineseTeacher ct = new ChineseTeacher();
		ct.teach();
		MathTeacher mt = new MathTeacher();
		mt.teach();
		
		//测试学生
		ChineseStu sc = new ChineseStu();
		sc.study();
		MathStu ms = new MathStu();
		ms.study();
		
		//测试动物
		Dog dog = new Dog();
		dog.eat();
		dog.lookHome();
		Cat cat = new Cat();
		cat.eat();
		cat.catchMouse();
		
	}

}
