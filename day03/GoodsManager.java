package cn.com.market;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsManager {
	private GoodsDao dao;
	private Scanner scan;
	public GoodsManager(){
		super();
		this.scan = new Scanner(System.in);
		this.dao = new GoodsDao();
	}
	//�������
	public void start(){
		System.out.println("------------���л������-----------");
		int flag=1;
		while(flag>0){
		print();
		int action = (int) getUserInput();
		while(action<1||action>5){
			System.out.println("�Ƿ�����������������");
			action = (int) getUserInput();
		}
		
		switch(action){
		case 1:
			goodsList();
			break;
		case 2:
			addGood();
			break;
		case 3:
			updateGoods();
			break;
		case 4:
			deleteGoods();
			break;
		default:
			flag = -1;
			break;
		}
		}
		System.out.println("ллʹ�ã��ټ�!");
	}
	
	//�û��������ݼ�飬���ظ������ǷǷ�����
	private double getUserInput(){
		double flag = -1;
		try{
			 
			flag = scan.nextDouble();
			
		}catch(Exception e){
			//
			scan.next();
		}
		return flag;
	}
	
	//����̨�Ѻ����
	private void print(){
		System.out.println("1:�����嵥  2:����»���  3:�޸Ļ���  4:ɾ������  5:�˳�ϵͳ");
		System.out.println("������������:");
	}
	//����̨��ʾ��Ϣ
	private void printMessage(String message){
		System.out.println(message);
	}
	//1.�����嵥
	private void goodsList(){
		ArrayList<Good> list  = dao.getGoodsList();
		System.out.println("------------�����嵥--------------");
		System.out.println("����"+"\t"+"����"+"\t"+"����"+"\t"+"����"+"\t");
		for(int i=0;i<list.size();i++){
			Good good = list.get(i);
			System.out.println(good.getId()+"\t"+good.getName()+"\t"+good.getPrice()+"\t"+good.getCount()+"\t");
		}
	}
	//2.��ӻ���
	private void addGood(){
		System.out.println("�����������:");
		//��ȡ�û���������
		String good_name = scan.next();
		System.out.println("������۸�:");
		//��ȡ�û�����۸�
		double  good_price = getUserInput();
		//�жϼ۸��Ƿ�Ϸ��������Ϸ�������������.
		while(good_price<=0){
			System.out.println("������������밴Ҫ����������!!!");
			good_price = getUserInput();
		}
		System.out.println("����������:");
		//��������
		int good_count  = (int) getUserInput();
		while(good_count<=0){
			System.out.println("������������밴Ҫ����������!!!");
			good_price = getUserInput();
		}
		//����good����
		Good good = new Good();
		//��������
		good.setId(dao.createGoodsId());
		good.setName(good_name);
		good.setPrice(good_price);
		good.setCount(good_count);
		String message = "";
		if(dao.addGoods(good)){
			message = "������ӳɹ�!";
		}else{
			message = "���ʧ�ܣ�δ֪����!";
		}
		printMessage(message);
		
	}
	//3.�޸Ļ���
	private void updateGoods(){
		//������
		goodsList();
		printMessage("������Ҫ�޸ĵĻ����,����no���˳��޸�");
		String goods_id = scan.next();
		if(goods_id.equalsIgnoreCase("no")){
			return;
		}
		int index = dao.getGoodsById(goods_id);
		while((index<0)){
			printMessage("δ֪�Ļ���,����������:");
			goods_id = scan.next();
			if(goods_id.equalsIgnoreCase("no")){
				break;
			}
			index  =dao.getGoodsById(goods_id);
		}
		
		//ѭ���޸�
		while(true){
		//���������Ϣ
		System.out.println("������Ϣ:");
		Good good  =dao.getGoodsList().get(index);
		System.out.println("1:����"+"\t"+"2:����"+"\t"+"3:����"+"\t");
		System.out.println(good.getName()+"\t"+good.getPrice()+"\t"+good.getCount()+"\t");
		//�޸�
		System.out.println("����Ҫ�޸ĵ����:");
		int item = (int) getUserInput();
		while(item<=0||item>3){
			System.out.println("�Ƿ����ݣ�����������!");
			item = (int) getUserInput();	
		}
		switch(item){
		  case 1:
			  	System.out.println("�������µ�����:");
			  	good.setName(scan.next());
			  	break;
		  case 2:
			  	System.out.println("�������µļ۸�:");
			  	double newprice = getUserInput();
			  	while(newprice<0){
			  		System.out.println("�Ƿ����ݣ�����������!");
			  		newprice = getUserInput();
			  	}
			  	good.setPrice(newprice);
			  	break;
		  case 3:
			  	System.out.println("�������µ�����:");
			  	int count=(int) getUserInput();
			  	while(count<=0){
			  		System.out.println("�Ƿ����ݣ�����������!");
			  		count = (int) getUserInput();
			  	}
			  	good.setCount(count);
			  	break;
			default:
				break;
		}
		System.out.println("�����޸��밴��������ύ������commit");
		if(scan.next().equalsIgnoreCase("commit")){
			break;
		}
		
		}
		
		
	}
	
	//ɾ������
	public void deleteGoods(){
		//�г���Ʒ
		goodsList();
		System.out.println("������Ҫɾ���Ļ��ţ�����no�˳�ɾ��");
		String goods_id = scan.next();
		if(goods_id.equalsIgnoreCase("no")){
			return;
		}
		System.out.println("ȷ��Ҫɾ����y/n");
		if(scan.next().equalsIgnoreCase("n")){
			return;
		}
		if(dao.deleteGoods(goods_id)){
			System.out.println("ɾ���ɹ�!");
		}else{
			System.out.println("ɾ��ʧ��,δ֪�Ļ���");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
