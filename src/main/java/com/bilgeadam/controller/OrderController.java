package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.OrderEntity;
import com.bilgeadam.util.IAdminCrud;

public class OrderController implements IAdminCrud<OrderEntity>, Serializable {
	private static final Logger logger = LogManager.getLogger(AdminAlbumController.class);
	private static final long serialVersionUID = -5526931395324306949L;
	
	@Override
	public void create(OrderEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			stockBelow(entity);
			session.getTransaction().commit();
			logger.info("kayıt işlemi tamamdır" + AdminArtistController.class);
		} catch (Exception e) {
			logger.error("kayıt işleme anında hata meydana geldi !!!!! " + AdminArtistController.class);
			e.printStackTrace();
		}
		
	}
	
	private void stockBelow(OrderEntity order) {
		try {
			AlbumEntity albumEntity = findAlbum(order.getAlbum().getId());
			if (albumEntity != null) {
				albumEntity.setStockCount(albumEntity.getStockCount() - order.getCount());
				albumEntity.setSalesCount(albumEntity.getSalesCount() + order.getCount());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(albumEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + UserController.class);
				
			}
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + UserController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(OrderEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(OrderEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<OrderEntity> list() {
		// TODO Auto-generated method stub
		return IAdminCrud.super.list();
	}
	
	@Override
	public OrderEntity find(long id) {
		Session session = databaseConnectionHibernate();
		OrderEntity orderEntity;
		try {
			orderEntity = session.find(OrderEntity.class, id);
			
			if (orderEntity != null) {
				System.out.println("bulundu... " + orderEntity);
				return orderEntity;
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
	
	public AlbumEntity findAlbum(long id) {
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
	public OrderEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IAdminCrud.super.singleResult(id);
	}
	
	@Override
	public Session databaseConnectionHibernate() {
		// TODO Auto-generated method stub
		return IAdminCrud.super.databaseConnectionHibernate();
	}
	
}
