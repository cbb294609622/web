package com.stu.bb;

import com.stu.bean.StudentBean;
import com.stu.service.StuService;

public class Test {
	
	public static void main(String[] args) {
		
		
		StudentBean stu = new StudentBean(002,"猫王","男","跳舞");
		StuService sStu = new StuService();
		//添加了学生信息
		sStu.addStu(stu);
		
		
	}
}
