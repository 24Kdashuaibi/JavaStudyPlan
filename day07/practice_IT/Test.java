package practice_IT;

public class Test {
	
	public static void main(String[] args) {
		
		//JAVAEE��������ʦ
		JavaEE je = new JavaEE("10010","���");
		je.work();
		
		//Android��������ʦ
		Android an  =new Android();
		an.setId("10086");
		an.setName("�Ÿ�");
		an.work();
		
		//Networkά������ʦ
		Network nw = new Network("1008610","˾���");
		nw.work();
		
		//Hardwareά������ʦ
		Hardware hd = new Hardware();
		hd.setId("100811");
		hd.setName("˾���");
		hd.work();
		
		
	}

}
