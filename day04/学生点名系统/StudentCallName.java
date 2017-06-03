package cn.com;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentCallName {
	
	private ArrayList<Student> list ;
	private Scanner scan;
	//�������
	public void  start(){
		callName();
		System.out.println("O(��_��)Oллʹ��");
	}
	//���췽���г�ʼ��������ѧ�����ݿ�
	public StudentCallName(){
		this.list = new ArrayList<Student>();
		this.scan = new Scanner(System.in);
		initStudentDB();
	}
	//ѧ������
	private String createStudentName(){
		//�� ����
		char[] surname = "��Ǯ��������֣��".toCharArray();
		//�� ����
		char[] name = "��ǰ���¹����ǵ���˪��ͷ�����µ�ͷ˼����".toCharArray();
		//�������
		Random ran = new Random();
		//�������5������Ϊ3���֣�С����Ϊ2����
		if(ran.nextInt(10)>5){
			return ""+surname[ran.nextInt(8)]+name[ran.nextInt(20)]+name[ran.nextInt(20)];
		}else{
			return ""+surname[ran.nextInt(8)]+name[ran.nextInt(20)];
		}
		
	}
	//��ʼ��ѧ�����ݿ�
	private void initStudentDB(){
		//ѧ��ID���涨Ϊ12104200��ʼ
		for(int i=0;i<15;i++){
			list.add(new Student(12104200+i,createStudentName()));
		}
	}
	//��ȡ����ѧ��ID����
	private ArrayList<String> getAllStudentId(ArrayList<Student> list){
		ArrayList<String> stu_id = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			stu_id.add(String.valueOf(list.get(i).getId()));
		}
		return stu_id;
		
	}
	//�����ṩ������ȡ���ݿ�
	public ArrayList<Student> getStudentList(){
		return list;
	}
	//ѧ������
	public void callName(){
		
		//�༶��Ϣ��ӡ
		classInfo(list);
		while(true){
		System.out.println("������Ҫ���������:  "+"1:����"+"\t"+"2:�鿴ǩ�����"+"\t"+"3:�˳�");
		//����û������Ƿ�Ϊ��ȷ����
		String num="";
		num = scan.next();
		if(num.equalsIgnoreCase("3")){
		
			break;
		}
		//
		switch(num){
		case "1":
			System.out.println("�������������:");
			System.out.println("1:�Զ�����         2:�ֶ�����");
			String action = "";
			while(true){
				action = scan.next();
				if(action.equalsIgnoreCase("1")||action.equalsIgnoreCase("2")){
					break;
				}else{
					System.out.println("��������ȷ�Ĳ������!!");
				}
			}
			if(action.equalsIgnoreCase("1")){
				//�Զ�����
				autoCallName(list);
			}else{
				//�ֶ�����
				noAutoCallName(list);
			}
			break;
		case "2":
			System.out.println("ǩ�����");
			//��ӡ��Ϣ
			classInfo(list);
			//���δ��ѧ����Ϣ
			printStudentNoSign(list);
			break;
		case "3":
			System.out.println("ллʹ��!");
			break;
		default:
			System.out.println("��������ȷ�Ĳ������:");
			break;
		}
		}
	}
		
	
	private void printStudentNoSign(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		int count=0;//δ��ѧ����
		System.out.println("---------------------δ��ѧ��ͳ��---------------------------------");
		System.out.println("\t"+"ѧ��"+"\t"+"����"+"\t"+"ǩ��"+"\t");
		for(int i=0;i<list.size();i++){
			if(!list.get(i).isSign()){
				//���ѧ����Ϣ
				count++;
				System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+"��"+"\t");
			}
		}
		System.out.println("�ܹ�"+list.size()+"��,δ��"+count+"��!");
	}
	private void noAutoCallName(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		//��ȡ����ѧ��ID
		ArrayList<String> stu_id = getAllStudentId(list);
		String id = "";
		System.out.println("������ѧ��ѧ��:");
		while(true){
			
			id = scan.next();
			if(id.equalsIgnoreCase("n")){
				break;
			}
			if(stu_id.contains(id)){
				for(int i=0;i<list.size();i++){
					if(list.get(i).getId()==Integer.parseInt(id)){
						System.out.println("++++++++ѧ����Ϣ+++++++");
						System.out.println("ѧ��:"+list.get(i).getId()+"\t"+"����:"+list.get(i).getName()+"\t");
						System.out.println("�����������ʾѧ���ѵ�����n��ʾѧ��δ��!");
						if(scan.next().equalsIgnoreCase("n")){
							list.get(i).setSign(false);
						}
						
					}
				}
				System.out.println("�������������������n���˳��ֶ�����!");
			}else{
				System.out.println("δ֪ѧ��!");
			}
			
		}
		
		
	}
	private void autoCallName(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		System.out.println("�Զ�������ʼ");
		System.out.println("�༶�ܹ�"+list.size()+"��,������Ҫ����������:");
		//�������
		int num = -1;
		while(true){
			try{
				num = scan.nextInt();
				if(num<=0||num>list.size()){
					
					System.out.println("���ݴ���������1��"+list.size()+"֮�������");
					
					continue;
				}else{
					break;
				}
			}catch(Exception e){
				scan.next();
				
				System.out.println("�Ƿ����ݣ�����������");
				continue;
			}
		}
		//�Զ�������ʼ
		Random ran = new Random();
		for(int i=0;i<num;i++){
			System.out.println("��ǰ������("+(i)+"/"+num+")λѧ��");
			//��ȡѧ��
			Student stu = list.get(ran.nextInt(list.size()));
			System.out.println(stu.getId()+"\t"+stu.getName()+"\t");
			System.out.println("����nΪδ���������Ϊ�ѵ�:");
			if(scan.next().equalsIgnoreCase("n")){
				stu.setSign(false);
			}
		}
		System.out.println("�Զ���������!");	
	}
	//�༶��Ϣ��ӡ
	private void classInfo(ArrayList<Student> list){
		System.out.println("-------------�༶��Ϣ-------------");
		System.out.println("ѧ��"+"\t"+"����"+"\t"+"ǩ��"+"\t");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+(list.get(i).isSign()==true?"��":"��")+"\t");
		}
		
	}
	
}
