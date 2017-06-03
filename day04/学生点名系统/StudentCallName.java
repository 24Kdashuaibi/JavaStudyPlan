package cn.com;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentCallName {
	
	private ArrayList<Student> list ;
	private Scanner scan;
	//程序入口
	public void  start(){
		callName();
		System.out.println("O(∩_∩)O谢谢使用");
	}
	//构造方法中初始化容器和学生数据库
	public StudentCallName(){
		this.list = new ArrayList<Student>();
		this.scan = new Scanner(System.in);
		initStudentDB();
	}
	//学生名字
	private String createStudentName(){
		//姓 数组
		char[] surname = "赵钱孙李周吴郑王".toCharArray();
		//名 数组
		char[] name = "床前明月光疑是地上霜举头望明月低头思故乡".toCharArray();
		//随机数类
		Random ran = new Random();
		//如果大于5则名字为3个字，小于则为2个字
		if(ran.nextInt(10)>5){
			return ""+surname[ran.nextInt(8)]+name[ran.nextInt(20)]+name[ran.nextInt(20)];
		}else{
			return ""+surname[ran.nextInt(8)]+name[ran.nextInt(20)];
		}
		
	}
	//初始化学生数据库
	private void initStudentDB(){
		//学生ID。规定为12104200开始
		for(int i=0;i<15;i++){
			list.add(new Student(12104200+i,createStudentName()));
		}
	}
	//获取所有学生ID集合
	private ArrayList<String> getAllStudentId(ArrayList<Student> list){
		ArrayList<String> stu_id = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			stu_id.add(String.valueOf(list.get(i).getId()));
		}
		return stu_id;
		
	}
	//对外提供方法获取数据库
	public ArrayList<Student> getStudentList(){
		return list;
	}
	//学生点名
	public void callName(){
		
		//班级信息打印
		classInfo(list);
		while(true){
		System.out.println("请输入要操作的序号:  "+"1:点名"+"\t"+"2:查看签到情况"+"\t"+"3:退出");
		//检测用户输入是否为正确数据
		String num="";
		num = scan.next();
		if(num.equalsIgnoreCase("3")){
		
			break;
		}
		//
		switch(num){
		case "1":
			System.out.println("请输入点名操作:");
			System.out.println("1:自动点名         2:手动点名");
			String action = "";
			while(true){
				action = scan.next();
				if(action.equalsIgnoreCase("1")||action.equalsIgnoreCase("2")){
					break;
				}else{
					System.out.println("请输入正确的操作序号!!");
				}
			}
			if(action.equalsIgnoreCase("1")){
				//自动点名
				autoCallName(list);
			}else{
				//手动点名
				noAutoCallName(list);
			}
			break;
		case "2":
			System.out.println("签到情况");
			//打印信息
			classInfo(list);
			//输出未到学生信息
			printStudentNoSign(list);
			break;
		case "3":
			System.out.println("谢谢使用!");
			break;
		default:
			System.out.println("请输入正确的操作序号:");
			break;
		}
		}
	}
		
	
	private void printStudentNoSign(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		int count=0;//未到学生数
		System.out.println("---------------------未到学生统计---------------------------------");
		System.out.println("\t"+"学号"+"\t"+"姓名"+"\t"+"签到"+"\t");
		for(int i=0;i<list.size();i++){
			if(!list.get(i).isSign()){
				//输出学生信息
				count++;
				System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+"否"+"\t");
			}
		}
		System.out.println("总共"+list.size()+"人,未到"+count+"人!");
	}
	private void noAutoCallName(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		//获取所有学生ID
		ArrayList<String> stu_id = getAllStudentId(list);
		String id = "";
		System.out.println("请输入学生学号:");
		while(true){
			
			id = scan.next();
			if(id.equalsIgnoreCase("n")){
				break;
			}
			if(stu_id.contains(id)){
				for(int i=0;i<list.size();i++){
					if(list.get(i).getId()==Integer.parseInt(id)){
						System.out.println("++++++++学生信息+++++++");
						System.out.println("学号:"+list.get(i).getId()+"\t"+"姓名:"+list.get(i).getName()+"\t");
						System.out.println("输入任意键表示学生已到，按n表示学生未到!");
						if(scan.next().equalsIgnoreCase("n")){
							list.get(i).setSign(false);
						}
						
					}
				}
				System.out.println("继续点名按任意键，按n则退出手动点名!");
			}else{
				System.out.println("未知学号!");
			}
			
		}
		
		
	}
	private void autoCallName(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		System.out.println("自动点名开始");
		System.out.println("班级总共"+list.size()+"人,请输入要点名的人数:");
		//检测数据
		int num = -1;
		while(true){
			try{
				num = scan.nextInt();
				if(num<=0||num>list.size()){
					
					System.out.println("数据错误，请输入1到"+list.size()+"之间的整数");
					
					continue;
				}else{
					break;
				}
			}catch(Exception e){
				scan.next();
				
				System.out.println("非法数据，请重新输入");
				continue;
			}
		}
		//自动点名开始
		Random ran = new Random();
		for(int i=0;i<num;i++){
			System.out.println("当前点名第("+(i)+"/"+num+")位学生");
			//获取学生
			Student stu = list.get(ran.nextInt(list.size()));
			System.out.println(stu.getId()+"\t"+stu.getName()+"\t");
			System.out.println("输入n为未到，任意键为已到:");
			if(scan.next().equalsIgnoreCase("n")){
				stu.setSign(false);
			}
		}
		System.out.println("自动点名结束!");	
	}
	//班级信息打印
	private void classInfo(ArrayList<Student> list){
		System.out.println("-------------班级信息-------------");
		System.out.println("学号"+"\t"+"姓名"+"\t"+"签到"+"\t");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+(list.get(i).isSign()==true?"是":"否")+"\t");
		}
		
	}
	
}
