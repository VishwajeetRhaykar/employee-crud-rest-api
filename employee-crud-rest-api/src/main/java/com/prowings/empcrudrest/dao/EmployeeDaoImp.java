package com.prowings.empcrudrest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.empcrudrest.model.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	@Autowired
	SessionFactory factory;

	@Override
	public void saveEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();

	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		emp =(Employee)session.get(Employee.class, id);
		tx.commit();
		
		System.out.println(emp);
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {

		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> Emplist = null;
		try {

			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery("from Employee");
			Emplist = query.list();
			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace(System.err);
		} 
		finally 
		{
			session.close();
			return Emplist;
		}
	}

	@Override
	public void deleteEmployeeByID(int id) {
		
		Employee emp;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		emp = session.get(Employee.class, id);
		session.delete(emp);
		tx.commit();
	}

}
