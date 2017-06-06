package practice_IT;

public class Test {
	
	public static void main(String[] args) {
		
		//JAVAEE开发工程师
		JavaEE je = new JavaEE("10010","李白");
		je.work();
		
		//Android开发工程师
		Android an  =new Android();
		an.setId("10086");
		an.setName("杜甫");
		an.work();
		
		//Network维护工程师
		Network nw = new Network("1008610","司马光");
		nw.work();
		
		//Hardware维护工程师
		Hardware hd = new Hardware();
		hd.setId("100811");
		hd.setName("司马缸");
		hd.work();
		
		
	}

}
