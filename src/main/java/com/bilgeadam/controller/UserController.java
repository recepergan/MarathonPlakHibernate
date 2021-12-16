package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.UserEntity;
import com.bilgeadam.util.IDatabaseCrud;

public class UserController implements IDatabaseCrud<UserEntity>, Serializable {
	
	private static final long serialVersionUID = -5019694167350973610L;
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Override
	public void create(UserEntity entity) {
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
	public boolean login(UserEntity entity) {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from UserEntity as str where str.email =:key1 and str.password =:key2";
		TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
		
		typedQuery.setParameter("key1", entity.getEmail());
		typedQuery.setParameter("key2", entity.getPassword());
		
		List<UserEntity> user = typedQuery.getResultList();
		logger.info("listelendi " + UserEntity.class);
		
		return (user.size() < 1) ? false : true;
	}
	
	@Override
	public void update(UserEntity entity) {
		try {
			UserEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setAddress(entity.getAddress());
				findEntity.setEmail(entity.getEmail());
				findEntity.setName(entity.getName());
				findEntity.setPassword(entity.getPassword());
				findEntity.setPhone(entity.getPhone());
				findEntity.setStatus(entity.getStatus());
				findEntity.setSurname(entity.getSurname());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + UserController.class);
			}
			
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + UserController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public UserEntity find(long id) {
		Session session = databaseConnectionHibernate();
		UserEntity userEntity;
		try {
			userEntity = session.find(UserEntity.class, id);
			
			if (userEntity != null) {
				System.out.println("bulundu... " + userEntity);
				return userEntity;
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
	public UserEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}
	
}
