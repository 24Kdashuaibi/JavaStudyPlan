package cn.com;

public class Student {
	private int id; //学生学号
	private String name; //姓名
	private boolean sign=true; //是否到课，true为到课,false为逃课，默认为到课
	
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
