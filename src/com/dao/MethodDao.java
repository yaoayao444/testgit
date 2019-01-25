package com.dao;

import java.util.List;

import com.beans.Stu_Tea;
import com.beans.Students;
import com.beans.Teacher;

public interface MethodDao {
	//登录验证
	public Object login(String beansName,String name,String password);
	//查询学生
	public List<Students> querystu();
	//查询老师
	public List<Teacher> querytea();
	//学生选课操作
	public int stuXK(Object obj);
	//查询选课状态
	public List<Stu_Tea> querystatus();
	//修改选课状态
	public int teaXK(int stuId,int teaId,int status);
	

}
