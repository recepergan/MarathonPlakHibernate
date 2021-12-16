package com.bilgeadam.main;

import com.bilgeadam.controller.AdminAlbumController;
import com.bilgeadam.entity.AlbumEntity;

public class HqlMainTest {
	
	public static void main(String[] args) {
		
		// searchLastTenAlbum();
		// listTheDiscountedFifteenAlbum();
		// listedByType("rock");
		
		listedBySinger("rock");
		
		// listedBySalesCount("rock");
		
	}
	
	public static void searchLastTenAlbum() {
		AdminAlbumController adminAlbumController = new AdminAlbumController();
		
		for (AlbumEntity temp : adminAlbumController.listTheLastTenAlbum()) {
			System.out.println(temp);
		}
	}
	
	public static void listTheDiscountedFifteenAlbum() {
		AdminAlbumController adminAlbumController = new AdminAlbumController();
		
		for (AlbumEntity temp : adminAlbumController.listTheDiscountedFifteenAlbum()) {
			System.out.println(temp);
		}
	}
	
	public static void listedByType(String tag) {
		AdminAlbumController adminAlbumController = new AdminAlbumController();
		
		for (AlbumEntity temp : adminAlbumController.listedByType(tag)) {
			System.out.println(temp);
		}
	}
	
	public static void listedBySinger(String tag) {
		AdminAlbumController adminAlbumController = new AdminAlbumController();
		
		adminAlbumController.listedByType(tag).forEach(System.out::println);
		
	}
	
	public static void listedBySalesCount(String tag) {
		AdminAlbumController adminAlbumController = new AdminAlbumController();
		
		for (AlbumEntity temp : adminAlbumController.listedByType(tag)) {
			System.out.println(temp);
		}
	}
	
}
