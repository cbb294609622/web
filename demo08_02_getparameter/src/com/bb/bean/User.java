package com.bb.bean;

import java.io.Serializable;
import java.util.Arrays;
/**
 * Serializable	是专门用于实现序列化的
 * 		实现了这个接口，意味着这个类是可以被序列化
 * 		实现这个接口，意味着可以在网络上直接传输一个对象		
 * 
 * 
 * 什么是序列化？
 * 		它支持一次性将一个对象存入到文件中	
 * 		
 * JavaBean规范
 * 		1.是一个共有类
 * 		2.提供私有字段
 * 		3.对于这些私有字段，提供get和set
 * 		4.提供一个共有的无参的构造
 * 		5.一般实现Serializable接口		
 * 
 * 
 * 
 * @author bb
 *
 */
public class User implements Serializable {
	
	private String username;
	private String[] password;
	
	public User() {
		super();
	}
	public User(String username, String[] password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
		
	
	public String[] getPassword() {
		return password;
	}
	public void setPassword(String[] password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [用户名=" + username + ", 密码="
				+ Arrays.toString(password) + "]";
	}
	

	
	
}
