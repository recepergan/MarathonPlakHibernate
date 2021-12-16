package com.bilgeadam.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.util.IAdminCrud;

public class AdminArtistController implements IAdminCrud<ArtistEntity> {
	private static final Logger logger = LogManager.getLogger(AdminArtistController.class);
	
	@Override
	public void create(ArtistEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("kayıt işlemi tamamdır" + AdminArtistController.class);
		} catch (Exception e) {
			logger.error("kayıt işleme anında hata meydana geldi !!!!! " + AdminArtistController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(ArtistEntity entity) {
		try {
			ArtistEntity findEntity = find(entity.getArtistId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + ArtistEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + AdminArtistController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(ArtistEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<ArtistEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from ArtistEntity as str where str.id>=:key order by str.creation_date desc";
		TypedQuery<ArtistEntity> typedQuery = session.createQuery(hql, ArtistEntity.class);
		
		int id = 1;
		typedQuery.setParameter("key", id);
		
		ArrayList<ArtistEntity> arrayList = (ArrayList<ArtistEntity>) typedQuery.getResultList();
		logger.info("listelendi " + ArtistEntity.class);
		return arrayList;
	}
	
	@Override
	public ArtistEntity find(long id) {
		Session session = databaseConnectionHibernate();
		ArtistEntity ArtistEntity;
		try {
			ArtistEntity = session.find(ArtistEntity.class, id);
			
			if (ArtistEntity != null) {
				System.out.println("bulundu... " + ArtistEntity);
				return ArtistEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + AdminArtistController.class);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Session databaseConnectionHibernate() {
		// TODO Auto-generated method stub
		return IAdminCrud.super.databaseConnectionHibernate();
	}
	
}
