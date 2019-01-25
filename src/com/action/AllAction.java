package com.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.beans.Stu_Tea;
import com.beans.Students;
import com.beans.Teacher;
import com.dao.MethodDao;
import com.dao.impl.MethodDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class AllAction {
	private String name;
	private String password;
	private int role;
	private String teaId;
	private int stuId;
	private int check;

	public String login() { // 方法返回值通常都是String,并且方法没有参数
		// HttpServletResponse response=ServletActionContext.getResponse();
		System.out.println(name);
		System.out.println(role);
		MethodDao md = new MethodDaoImpl();
		if (0 == role) {
			Teacher t = (Teacher) md.login("Teacher", name, password);
			System.out.println("t" + t);
			if (t != null) {
				ActionContext.getContext().getSession().put("t", t);
				return "teasuccess";
			}
		}
		if (1 == role) {
			Students s = (Students) md.login("Students", name, password);
			System.out.println("s" + s);
			if (s != null) {
				ActionContext.getContext().getSession().put("s", s);
				return "stusuccess";
			}
		}

		return "error";

	}

	public void stuxk() throws Exception {
		System.out.println(stuId);
		System.out.println(teaId);
		
		int count = 0;
		MethodDao md = new MethodDaoImpl();
		String [] teaId_val=teaId.trim().split(" ");
		for (int i = 0; i < teaId_val.length; i++) {
			Stu_Tea st = new Stu_Tea();
			st.setStuId(stuId);
			st.setTeaId(Integer.parseInt(teaId_val[i]));
			st.setStatus(0);
			if (md.stuXK(st) > 0) {
				count++;
			}
		}
		if (count == teaId_val.length) {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("选课成功，等老师进行确认");
		}

	}
	public String teaXK(){
		System.out.println("状态号"+check);
		System.out.println("学生"+stuId);
		System.out.println("老师"+teaId);
		MethodDao md = new MethodDaoImpl();
		int result=md.teaXK(stuId, Integer.parseInt(teaId), check);
		if(result>0){
			return "teasuccess";
		}
		return "error";
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	

	
}
