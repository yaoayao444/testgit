package com.dao;

import java.util.List;

import com.beans.Stu_Tea;
import com.beans.Students;
import com.beans.Teacher;

public interface MethodDao {
	//��¼��֤
	public Object login(String beansName,String name,String password);
	//��ѯѧ��
	public List<Students> querystu();
	//��ѯ��ʦ
	public List<Teacher> querytea();
	//ѧ��ѡ�β���
	public int stuXK(Object obj);
	//��ѯѡ��״̬
	public List<Stu_Tea> querystatus();
	//�޸�ѡ��״̬
	public int teaXK(int stuId,int teaId,int status);
	

}
