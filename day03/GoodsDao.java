package cn.com.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//dao  ��Ʒ����ɾ�Ĳ�
public class GoodsDao {
	private ArrayList<Good> list;
	
	public GoodsDao(){
		list = new ArrayList<Good>();
		init();
	}
	//������ƷID,ǰ��λΪ��д��ĸ����5λΪ����
	public String createGoodsId(){
		//idǰ׺
		String str = "QAZWSXEDCRFVTGBYHNUJMIKOLP";
		//������ҵõ�ǰ׺
		str = shuffleStr(str);
		//id��׺,�����Ե���0
		int num =0;
		while(num==0){
			num = (int) (Math.random()*10000);
		}
		return str+num;
	}
	//��ȡǰ׺
	private String shuffleStr(String str) {
		// TODO Auto-generated method stub
		char[] ch = str.toCharArray();
		ArrayList<Character> ch_list = new ArrayList<Character>();
		for(int i=0;i<ch.length;i++){
			ch_list.add(ch[i]);
		}
		
		//�����ȡ�����ַ����ǰ׺
		Random ran = new Random();
		String goods_id_prefix="";
		for(int i=0;i<3;i++){
			//�����ַ�����
			Collections.shuffle(ch_list);
			//��ȡǰ׺
			goods_id_prefix+=ch_list.get(ran.nextInt(26));
		}
		
		return goods_id_prefix;
	}
	//��Ʒ���ʼ��
	public ArrayList<Good> init(){
		list.add(new Good(createGoodsId(),"��ʾ��",499.99,100));
		list.add(new Good(createGoodsId(),"����",99.99,88));
		list.add(new Good(createGoodsId(),"���",200.00,60));
		list.add(new Good(createGoodsId(),"ɢ����",49.88,1000));
		return list;
	}
	//������Ʒ
	public boolean addGoods(Good good){
		good.setId(createGoodsId());
		return list.add(good);
		
	}
	//ɾ��
	public boolean deleteGoods(String goods_id){
		//�ҵ��ö�����list�е�λ��
		int index = getGoodsById(goods_id);
		if(index<0){
			return false;
		}
		list.remove(index);
		return true;
	}
	//�޸�����
	public boolean updateGoods(Good good){
		//�ҵ��ö�����list�е�λ��
		int index  =getGoodsById(good.getId());
		if(index<0){
			return false;
		}
		//�滻
		list.set(index, good);
		return true;
	}
	//������
	public ArrayList<Good> getGoodsList(){
		return list;
	}
	//��ID ��,���ظö����ڼ����е�λ�ã���Ϊ-1�򲻴���
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
