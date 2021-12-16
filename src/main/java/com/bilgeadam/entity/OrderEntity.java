package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_orders")
public class OrderEntity implements Serializable {
	
	private static final long serialVersionUID = 469309253542157259L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long invoice_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "albumId")
	private AlbumEntity album;
	
	private int count;
	
	private double sumPrice;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date creation_date;
	
	public OrderEntity(int count) {
		super();
		
		this.count = count;
		
	}
	
	public long getInvoice_id() {
		return invoice_id;
	}
	
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	
	public UserEntity getUser() {
		return user;
	}
	
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public AlbumEntity getAlbum() {
		return album;
	}
	
	public void setAlbum(AlbumEntity album) {
		this.album = album;
		
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public double getSumPrice() {
		return sumPrice;
	}
	
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	public Date getCreation_date() {
		return creation_date;
	}
	
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
}
