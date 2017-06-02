package cn.com.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//dao  物品的增删改查
public class GoodsDao {
	private ArrayList<Good> list;
	
	public GoodsDao(){
		list = new ArrayList<Good>();
		init();
	}
	//产生物品ID,前三位为大写字母，后5位为数字
	public String createGoodsId(){
		//id前缀
		String str = "QAZWSXEDCRFVTGBYHNUJMIKOLP";
		//随机打乱得到前缀
		str = shuffleStr(str);
		//id后缀,不可以等于0
		int num =0;
		while(num==0){
			num = (int) (Math.random()*10000);
		}
		return str+num;
	}
	//获取前缀
	private String shuffleStr(String str) {
		// TODO Auto-generated method stub
		char[] ch = str.toCharArray();
		ArrayList<Character> ch_list = new ArrayList<Character>();
		for(int i=0;i<ch.length;i++){
			ch_list.add(ch[i]);
		}
		
		//随机获取三个字符组成前缀
		Random ran = new Random();
		String goods_id_prefix="";
		for(int i=0;i<3;i++){
			//打乱字符数组
			Collections.shuffle(ch_list);
			//获取前缀
			goods_id_prefix+=ch_list.get(ran.nextInt(26));
		}
		
		return goods_id_prefix;
	}
	//物品库初始化
	public ArrayList<Good> init(){
		list.add(new Good(createGoodsId(),"显示器",499.99,100));
		list.add(new Good(createGoodsId(),"键盘",99.99,88));
		list.add(new Good(createGoodsId(),"鼠标",200.00,60));
		list.add(new Good(createGoodsId(),"散热器",49.88,1000));
		return list;
	}
	//增加物品
	public boolean addGoods(Good good){
		good.setId(createGoodsId());
		return list.add(good);
		
	}
	//删除
	public boolean deleteGoods(String goods_id){
		//找到该对象在list中的位置
		int index = getGoodsById(goods_id);
		if(index<0){
			return false;
		}
		list.remove(index);
		return true;
	}
	//修改属性
	public boolean updateGoods(Good good){
		//找到该对象在list中的位置
		int index  =getGoodsById(good.getId());
		if(index<0){
			return false;
		}
		//替换
		list.set(index, good);
		return true;
	}
	//查所有
	public ArrayList<Good> getGoodsList(){
		return list;
	}
	//按ID 查,返回该对象在集合中的位置，若为-1则不存在
	public int getGoodsById(String goods_id){
		int index=-1;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId().equalsIgnoreCase(goods_id)){
				index=i;
				break;
			}
		}
		return index;
		
	}
	
}
