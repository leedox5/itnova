package com.itnova.task;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.itnova.hibernate.HibernateUtil;
import com.itnova.util.DateUtil;

public class TaskManager {

	public int getTask(String pgmId, String userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();;
		Transaction tx = null;
		int size = 0;
		try {
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(JAR_PD00_T.class);
			crit.add(Restrictions.eq("programId", pgmId));
			crit.add(Restrictions.eq("programUser", userId));
			crit.add(Restrictions.eq("programStatus", "10"));
			
			size = crit.list().size();
			
			tx.commit();
		} catch (HibernateException e) {
			if( tx != null) tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
		return size;
	}

	public int addTask(String programName, String userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();;
		Transaction tx = null;
		Integer taskId = null;
		
		try {
			tx = session.beginTransaction();

			JAR_PD00_T task = new JAR_PD00_T();
			task.setProgramId(programName);
			task.setProgramUser(userId);
			task.setStartTime(DateUtil.getTime());
			task.setProgramStatus("10");
			task.setResultMessage("Ã³¸®Áß...");
			taskId = (Integer)session.save(task);
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null) tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
		return taskId;
	}

	public void updateTask(int taskId, String stat, String empNo, String msgCode, String msgContent) {
		Session session = HibernateUtil.getSessionFactory().openSession();;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			JAR_PD00_T task = (JAR_PD00_T)session.get(JAR_PD00_T.class, taskId);
			task.setEndTime(DateUtil.getTime());
			task.setProgramUser(empNo);
			task.setProgramStatus(stat);
			task.setResultCode(msgCode);
			task.setResultMessage(msgContent);
			session.update(task);
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null) tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	public String getTaskStatus(int taskId) {
		Session session = HibernateUtil.getSessionFactory().openSession();;
		Transaction tx = null;
		String ret = "XX";
		try {
			tx = session.beginTransaction();
			JAR_PD00_T task = (JAR_PD00_T)session.get(JAR_PD00_T.class, taskId);
			if(task != null) {
				ret = task.getProgramStatus() + "|" + task.getResultMessage();
			}
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null) tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
		return ret;
	}
}
