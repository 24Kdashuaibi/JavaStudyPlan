package practice_two;

public class Test {
	
	public static void main(String[] args) {
		//������ʦ
		ChineseTeacher ct = new ChineseTeacher();
		ct.teach();
		MathTeacher mt = new MathTeacher();
		mt.teach();
		
		//����ѧ��
		ChineseStu sc = new ChineseStu();
		sc.study();
		MathStu ms = new MathStu();
		ms.study();
		
		//���Զ���
		Dog dog = new Dog();
		dog.eat();
		dog.lookHome();
		Cat cat = new Cat();
		cat.eat();
		cat.catchMouse();
		
	}

}
