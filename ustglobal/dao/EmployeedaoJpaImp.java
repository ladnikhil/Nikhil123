package com.ustglobal.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ustglobal.mywebapp.dto.EmployeeInfoBean;

public class EmployeedaoJpaImp implements EmployeeDao{

	@Override
	public EmployeeInfoBean searchEmployee(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = emf.createEntityManager();
		EmployeeInfoBean employeeinfobean = null;
		
		try {
			 employeeinfobean = manager.find(EmployeeInfoBean.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeinfobean;
	}

}
