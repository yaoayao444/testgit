package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Stu_Tea;
import com.beans.Students;
import com.beans.Teacher;
import com.dao.MethodDao;
import com.util.HibUtil;

public class MethodDaoImpl implements MethodDao {

	// 登录验证
	public Object login(String beansName, String name, String password) {

		Session s = HibUtil.getSession();
		if ("Students".equals(beansName)) {
			String hql = "select a from Students a where a.name=? and a.password=?";
			return s.createQuery(hql).setParameter(0, name)
					.setParameter(1, password).uniqueResult();
		} else {
			String hql = "select a from Teacher a where a.name=? and a.password=?";
			return s.createQuery(hql).setParameter(0, name)
					.setParameter(1, password).uniqueResult();
		}

	}

	// 查询学生
	public List<Students> querystu() {
		Session s = HibUtil.getSession();
		return s.createQuery("from Students").list();
	}

	// 查询老师
	public List<Teacher> querytea() {
		Session s = HibUtil.getSession();
		return s.createQuery("from Teacher").list();
	}

	// 学生选课
	public int stuXK(Object obj) {
		Session s = null;
		Transaction tx = null;
		Serializable i = null;
		try {
			s = HibUtil.getSession();
			tx = s.beginTransaction();
			i = s.save(obj); // 返回值为当前数据库id
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibUtil.close(s);
		}
		return (Integer) i;
	}

	// 查询状态
	public List<Stu_Tea> querystatus() {
		Session s = HibUtil.getSession();
		return s.createQuery("from Stu_Tea").list();
	}

	// 修改选课状态
	public int teaXK(int stuId, int teaId, int status) {
		int result = 0;
		Session s = null;
		try {
			s = HibUtil.getSession();
			Transaction tx = s.beginTransaction();
			Query q = s
					.createQuery("update Stu_Tea set status=? where stuId=? and teaId=?");
			q.setParameter(0, status);
			q.setParameter(1, stuId);
			q.setParameter(2, teaId);
			result = q.executeUpdate(); // 无论删除还是修改，都执行此方法

			tx.commit();

		} finally {
			HibUtil.close(s);
		}
		return result;
	}

}
