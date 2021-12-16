package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.entity.OrderEntity;
import com.bilgeadam.entity.UserEntity;

public class HibernateUtil {
	// dış dünyada bununla bu classa erişim sağlayabileceğim.
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	// hibernate ile bağlantı kuracağım yer
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();
	
	// method
	private static SessionFactory sessionFactoryHibernate() {
		try {
			// instance
			Configuration configuration = new Configuration();
			
			// entity classlarımızı buraya ekleyeceğiz
			configuration.addAnnotatedClass(UserEntity.class);
			configuration.addAnnotatedClass(AlbumEntity.class);
			configuration.addAnnotatedClass(ArtistEntity.class);
			configuration.addAnnotatedClass(OrderEntity.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
