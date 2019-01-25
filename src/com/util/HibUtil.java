package com.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibUtil {
	
	private static SessionFactory sessionFactory;
	
	static{
		//创建读取配置文件的对象
		Configuration cfx=new Configuration();
		//读取配置文件
		cfx.configure();  //会默认读取hibernate主配置文件,括号中也可以写上名字
		//创建session工厂
		sessionFactory=cfx.buildSessionFactory();
	}
	
	//得到session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	//得到工厂
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//关闭资源
	public static void close(Session s){
		if(s!=null){
			s.close();
		}
	}
	
	
	//标准的添加方法
	public static int add(Object obj){
		Session s=null;
		Transaction tx=null;
		Serializable i=null;
		try{
			s=HibUtil.getSession();
			tx=s.beginTransaction();
			i=s.save(obj);  //返回值为当前数据库id
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibUtil.close(s);
		}
		return (Integer)i;
	}
	
}

