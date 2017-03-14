package com.stu.bean;

public class StudentBean {
	private int id;
	private String name;
	private String sex;
	private String like;

	public StudentBean() {
	}

	public StudentBean(int id, String name, String sex, String like) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.like = like;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", like=" + like + "]";
	}
	
	
	
}
