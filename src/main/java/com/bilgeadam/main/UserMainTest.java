package com.bilgeadam.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bilgeadam.controller.AdminAlbumController;
import com.bilgeadam.controller.AdminArtistController;
import com.bilgeadam.controller.AdminController;
import com.bilgeadam.controller.OrderController;
import com.bilgeadam.controller.UserController;
import com.bilgeadam.entity.AdminEntity;
import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.entity.OrderEntity;
import com.bilgeadam.entity.UserEntity;

public class UserMainTest {
	public static void main(String[] args) throws IOException {
		
		byte[] imgCover = Files.readAllBytes(Paths.get("a.jpg"));
		
		UserController userController = new UserController();
		
		// Üye olma işlemidir
		UserEntity userRecep = new UserEntity("rcp", "ergan", "rcpgmail", "123", "274", "istanbul", "true");
		userController.create(userRecep);
		UserEntity userRagıp = new UserEntity("ragıpp", "sdf", "df", "1243", "2474", "istanbul", "true");
		userController.create(userRagıp);
		UserEntity userM = new UserEntity("asdfg", "wdfgb", "sdf", "123", "274", "istanbul", "true");
		userController.create(userM);
		
		// Login işlemi
		if (userController.login(new UserEntity("rcpgmail", "123"))) {
			System.out.println("Giriş başarılıdır");
		} else {
			System.out.println("şifre ve password kontrol ediniz");
		}
		
		// create sanatçı
		AdminArtistController artistController = new AdminArtistController();
		ArtistEntity muratEntity = new ArtistEntity("murat", "kekilli", "yaşıyor");
		artistController.create(muratEntity);
		ArtistEntity sfdvEntity = new ArtistEntity("kalen", "res", "yaşıyor");
		artistController.create(sfdvEntity);
		ArtistEntity sadEntity = new ArtistEntity("er", "qw", "yaşıyor");
		artistController.create(sadEntity);
		muratEntity = artistController.find(1);
		
		// create ALbum
		AdminAlbumController albumController = new AdminAlbumController();
		AlbumEntity albumEntity = new AlbumEntity("bu akşam ölüürüm", 15.0, 0.10, "rock", "satılabilir", 5L, 10L);
		AlbumEntity albumEntity1 = new AlbumEntity("bu m ölüürüm", 1.0, 0.10, "rock", "satılabilir", 5L, 10L);
		AlbumEntity albumEntity2 = new AlbumEntity("bu akşam ürüm", 15.8, 0.10, "rock", "satılabilir", 5L, 10L);
		albumEntity.setImgCover(imgCover);
		albumEntity.setSinger(muratEntity);
		albumController.create(albumEntity);
		
		albumEntity1.setImgCover(imgCover);
		albumEntity1.setSinger(muratEntity);
		albumController.create(albumEntity1);
		
		albumEntity2.setImgCover(imgCover);
		albumEntity2.setSinger(muratEntity);
		albumController.create(albumEntity2);
		
		// Burası su an çalışmıyor
		
		OrderEntity order = new OrderEntity(5);
		OrderController orderController = new OrderController();
		order.setUser(userRecep);
		order.setAlbum(albumEntity);
		orderController.create(order);
		// Burası su an çalışmıyor
		
		AdminController adminController = new AdminController();
		adminController.adminLogin(new AdminEntity("admin", "qwerty"));
		
	}
}
