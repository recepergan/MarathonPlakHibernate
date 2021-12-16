package com.bilgeadam.controller;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.AdminEntity;
import com.bilgeadam.util.IAdminCrud;

public class AdminController implements IAdminCrud<AdminEntity>, Serializable {
	
	private static final String ADMIN = "admin";
	private static final String PASSWORD = "qwerty";
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Override
	public void create(AdminEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("kayıt işlemi tamamdır" + UserController.class);
		} catch (Exception e) {
			logger.error("kayıt işleme anında hata meydana geldi !!!!! " + UserController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(AdminEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean adminLogin(AdminEntity entity) {
		if (entity.getName().equals(ADMIN) && entity.getPassword().equals(PASSWORD)) {
			System.out.println("Giriş başarılıdır");
			return true;
		} else {
			System.out.println("şifre ve password kontrol ediniz");
			return false;
		}
	}
	
	@Override
	public AdminEntity find(long id) {
		Session session = databaseConnectionHibernate();
		AdminEntity adminEntity;
		try {
			adminEntity = session.find(AdminEntity.class, id);
			
			if (adminEntity != null) {
				System.out.println("bulundu... " + adminEntity);
				return adminEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + UserController.class);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void delete(AdminEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
}
