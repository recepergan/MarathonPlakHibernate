package com.bilgeadam.util;

import org.hibernate.Session;

public interface IDatabaseCrud<T> {
	
	public void create(T entity);// ekleme
	
	public boolean login(T entity);// login
	
	public void update(T entity);// güncelleme
	
	default T find(long id) {
		return null;
	}
	
	default T singleResult(long id) {
		return null;
	}
	
	// gövdeli method
	default Session databaseConnectionHibernate() {
		return HibernateUtil.getSessionfactory().openSession();
	}
	
}