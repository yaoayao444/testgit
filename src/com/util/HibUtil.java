package com.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibUtil {
	
	private static SessionFactory sessionFactory;
	
	static{
		//������ȡ�����ļ��Ķ���
		Configuration cfx=new Configuration();
		//��ȡ�����ļ�
		cfx.configure();  //��Ĭ�϶�ȡhibernate�������ļ�,������Ҳ����д������
		//����session����
		sessionFactory=cfx.buildSessionFactory();
	}
	
	//�õ�session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	//�õ�����
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//�ر���Դ
	public static void close(Session s){
		if(s!=null){
			s.close();
		}
	}
	
	
	//��׼����ӷ���
	public static int add(Object obj){
		Session s=null;
		Transaction tx=null;
		Serializable i=null;
		try{
			s=HibUtil.getSession();
			tx=s.beginTransaction();
			i=s.save(obj);  //����ֵΪ��ǰ���ݿ�id
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibUtil.close(s);
		}
		return (Integer)i;
	}
	
}

