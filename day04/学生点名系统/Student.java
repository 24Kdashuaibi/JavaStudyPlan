package cn.com;

public class Student {
	private int id; //ѧ��ѧ��
	private String name; //����
	private boolean sign=true; //�Ƿ񵽿Σ�trueΪ����,falseΪ�ӿΣ�Ĭ��Ϊ����
	
	public Student(){
		super();
	}
	public Student(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSign() {
		return sign;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	
	

}
