package com.bb.dao;

import java.util.ArrayList;
import java.util.List;

import com.bb.bean.Product;

/**
 * 此类存放了对Product 对象的CRUD方法
 * @author bb
 *
 */
public class ProductDao {
	//模拟 数据库，存放所有商品数据
	private static List<Product> datas = new ArrayList<Product>();
	
	/**
	 * 初始化商品数据
	 * 只执行一次
	 */
	static{
		for (int i = 1; i <= 10; i++) {
			datas.add(new Product(""+i,"笔记本电脑"+i,"LN00"+i,4000+i));
		}
		
	}
	
	
	/**
	 * 查询所有商品的方法
	 */
	public List<Product> findAll(){
		return datas;
	}
	
	/**
	 * 根据编号查询商品的方法
	 */
	public Product findById(String id){
		for (Product p : datas) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	
	
}
