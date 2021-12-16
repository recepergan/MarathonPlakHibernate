package com.bilgeadam.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.util.IAdminCrud;

public class AdminAlbumController implements IAdminCrud<AlbumEntity> {
	private static final Logger logger = LogManager.getLogger(AdminAlbumController.class);
	
	@Override
	public void create(AlbumEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("kayıt işlemi tamamdır" + AdminAlbumController.class);
		} catch (Exception e) {
			logger.error("kayıt işleme anında hata meydana geldi !!!!! " + AdminAlbumController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(AlbumEntity entity) {
		try {
			AlbumEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + AlbumEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + AdminAlbumController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(AlbumEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<AlbumEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from AlbumEntity as str where str.id>=:key order by str.creation_date desc";
		TypedQuery<AlbumEntity> typedQuery = session.createQuery(hql, AlbumEntity.class);
		
		int id = 1;
		typedQuery.setParameter("key", id);
		
		ArrayList<AlbumEntity> arrayList = (ArrayList<AlbumEntity>) typedQuery.getResultList();
		logger.info("listelendi " + AlbumEntity.class);
		return arrayList;
	}
	
	@Override
	public AlbumEntity find(long id) {
		Session session = databaseConnectionHibernate();
		AlbumEntity albumEntity;
		try {
			albumEntity = session.find(AlbumEntity.class, id);
			
			if (albumEntity != null) {
				System.out.println("bulundu... " + albumEntity);
				return albumEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + AdminAlbumController.class);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public AlbumEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IAdminCrud.super.singleResult(id);
	}
	
	@Override
	public Session databaseConnectionHibernate() {
		// TODO Auto-generated method stub
		return IAdminCrud.super.databaseConnectionHibernate();
	}
	
}
