package com.cbb.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cbb.dao.ContactDao;
import com.cbb.dao.impl.ContactDaoImpl;
import com.cbb.entity.Contact;


/**
 * 联系人操作实现类的测试类
 * @author APPle
 *
 */
public class TestContactOperatorImpl {
	ContactDao operator = null;
	
	/**
	 * 初始化对象实例
	 */
	@Before
	public void init(){
		operator = new ContactDaoImpl();
	}
	

	@Test
	public void testAddContact(){
		for (int i = 1; i <= 10; i++) {
			Contact contact = new Contact();
			//contact.setId("1");
			contact.setName("张三"+i);
			if (i%2 == 1) {
				contact.setGender("男");
			}else {
				contact.setGender("女");
			}
			
			contact.setAge(20+i);
			contact.setPhone("13422223333"+i);
			contact.setEmail("eric"+i+"@qq.com");
			contact.setQq("333344"+i);
			operator.addContact(contact);
		}
	}
	
	@Test
	public void testUpdateContact(){
		Contact contact = new Contact();
		contact.setId("7264ab3a69d64236941a50afb4a74331"); //修改的ID
		contact.setName("李四");
		contact.setGender("女");
		contact.setAge(30);
		contact.setPhone("135222233333");
		contact.setEmail("zhangsan@qq.com");
		contact.setQq("33334444");
		operator.updateContact(contact);
	}
	
	@Test
	public void testDeleteContact(){
		operator.deleteContact("7264ab3a69d64236941a50afb4a74331");//删除的ID
	}
	
	@Test
	public void testFindAll(){
		List<Contact> list = operator.findAll();
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}
	
	@Test
	public void testFindById(){
		Contact contact = operator.findById("a5a7f9a2d439448a9858a18ee645dc6b");//查询的ID
		System.out.println(contact);
	}
}
