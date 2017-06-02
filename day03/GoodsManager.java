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
	//程序入口
	public void start(){
		System.out.println("------------超市货物管理-----------");
		int flag=1;
		while(flag>0){
		print();
		int action = (int) getUserInput();
		while(action<1||action>5){
			System.out.println("非法操作，请重新输入");
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
		System.out.println("谢谢使用，再见!");
	}
	
	//用户输入数据检查，返回负数则是非法输入
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
	
	//控制台友好输出
	private void print(){
		System.out.println("1:货物清单  2:添加新货物  3:修改货物  4:删除货物  5:退出系统");
		System.out.println("请输入操作序号:");
	}
	//控制台提示信息
	private void printMessage(String message){
		System.out.println(message);
	}
	//1.货物清单
	private void goodsList(){
		ArrayList<Good> list  = dao.getGoodsList();
		System.out.println("------------货物清单--------------");
		System.out.println("货号"+"\t"+"名称"+"\t"+"单价"+"\t"+"数量"+"\t");
		for(int i=0;i<list.size();i++){
			Good good = list.get(i);
			System.out.println(good.getId()+"\t"+good.getName()+"\t"+good.getPrice()+"\t"+good.getCount()+"\t");
		}
	}
	//2.添加货物
	private void addGood(){
		System.out.println("请输入货物名:");
		//获取用户输入名称
		String good_name = scan.next();
		System.out.println("请输入价格:");
		//获取用户输入价格
		double  good_price = getUserInput();
		//判断价格是否合法，若不合法，则重新输入.
		while(good_price<=0){
			System.out.println("数据输入错误，请按要求输入数据!!!");
			good_price = getUserInput();
		}
		System.out.println("请输入数量:");
		//货物数量
		int good_count  = (int) getUserInput();
		while(good_count<=0){
			System.out.println("数据输入错误，请按要求输入数据!!!");
			good_price = getUserInput();
		}
		//创建good对象
		Good good = new Good();
		//赋予属性
		good.setId(dao.createGoodsId());
		good.setName(good_name);
		good.setPrice(good_price);
		good.setCount(good_count);
		String message = "";
		if(dao.addGoods(good)){
			message = "货物添加成功!";
		}else{
			message = "添加失败，未知错误!";
		}
		printMessage(message);
		
	}
	//3.修改货物
	private void updateGoods(){
		//检测货号
		goodsList();
		printMessage("请输入要修改的货物号,输入no则退出修改");
		String goods_id = scan.next();
		if(goods_id.equalsIgnoreCase("no")){
			return;
		}
		int index = dao.getGoodsById(goods_id);
		while((index<0)){
			printMessage("未知的货号,请重新输入:");
			goods_id = scan.next();
			if(goods_id.equalsIgnoreCase("no")){
				break;
			}
			index  =dao.getGoodsById(goods_id);
		}
		
		//循环修改
		while(true){
		//输出货物信息
		System.out.println("货物信息:");
		Good good  =dao.getGoodsList().get(index);
		System.out.println("1:名称"+"\t"+"2:单价"+"\t"+"3:数量"+"\t");
		System.out.println(good.getName()+"\t"+good.getPrice()+"\t"+good.getCount()+"\t");
		//修改
		System.out.println("输入要修改的序号:");
		int item = (int) getUserInput();
		while(item<=0||item>3){
			System.out.println("非法数据，请重新输入!");
			item = (int) getUserInput();	
		}
		switch(item){
		  case 1:
			  	System.out.println("请输入新的名称:");
			  	good.setName(scan.next());
			  	break;
		  case 2:
			  	System.out.println("请输入新的价格:");
			  	double newprice = getUserInput();
			  	while(newprice<0){
			  		System.out.println("非法数据，请重新输入!");
			  		newprice = getUserInput();
			  	}
			  	good.setPrice(newprice);
			  	break;
		  case 3:
			  	System.out.println("请输入新的数量:");
			  	int count=(int) getUserInput();
			  	while(count<=0){
			  		System.out.println("非法数据，请重新输入!");
			  		count = (int) getUserInput();
			  	}
			  	good.setCount(count);
			  	break;
			default:
				break;
		}
		System.out.println("继续修改请按任意键，提交请输入commit");
		if(scan.next().equalsIgnoreCase("commit")){
			break;
		}
		
		}
		
		
	}
	
	//删除货物
	public void deleteGoods(){
		//列出物品
		goodsList();
		System.out.println("请输入要删除的货号，输入no退出删除");
		String goods_id = scan.next();
		if(goods_id.equalsIgnoreCase("no")){
			return;
		}
		System.out.println("确定要删除吗？y/n");
		if(scan.next().equalsIgnoreCase("n")){
			return;
		}
		if(dao.deleteGoods(goods_id)){
			System.out.println("删除成功!");
		}else{
			System.out.println("删除失败,未知的货号");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
