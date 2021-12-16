package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_artists")
public class ArtistEntity implements Serializable {
	
	private static final long serialVersionUID = -1169273689828879171L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long artistId;
	private String name;
	private String surname;
	private String bio;
	@OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<AlbumEntity> albums = new ArrayList<AlbumEntity>();
	
	public ArtistEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public ArtistEntity(String name, String surname, String bio) {
		super();
		this.name = name;
		this.surname = surname;
		this.bio = bio;
		
	}
	
	@Override
	public String toString() {
		return "ArtistEntity [artistId=" + artistId + ", name=" + name + ", surname=" + surname + ", bio=" + bio + "]";
	}
	
	public long getArtistId() {
		return artistId;
	}
	
	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public List<AlbumEntity> getAlbums() {
		if (albums == null) {
			albums = new ArrayList();
		}
		return albums;
	}
	
	public void setAlbums(List<AlbumEntity> albums) {
		this.albums = albums;
	}
	
}
