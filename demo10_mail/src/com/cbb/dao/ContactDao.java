package com.cbb.dao;

import java.util.List;

import com.cbb.entity.Contact;

/**
 * 联系人的DAO接口
 * @author bb
 *
 */
public interface ContactDao {
	/**
	 * 添加联系人
	 * @param contact
	 */
	public void addContact(Contact contact);
	/**
	 * 修改联系人
	 * @param contact
	 */
	public void updateContact(Contact contact);
	/**
	 * 删除联系人
	 * @param contact
	 */
	public void deleteContact(String id);
	/**
	 * 查询所有联系人
	 * @return
	 */
	public List<Contact> findAll();
	/**
	 * 根据编号查询联系人
	 * @param id
	 * @return
	 */
	public Contact findById(String id);
	
}
