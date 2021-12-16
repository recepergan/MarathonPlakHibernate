package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_album")
public class AlbumEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "album_id")
	private long id;
	
	@Column(name = "album_name")
	private String name;
	
	@Column(name = "album_pierce")
	private double pierce;
	
	@Lob
	@Column(name = "album_img_cover")
	private byte[] imgCover;
	
	@Column(name = "album_discount_rate")
	private double discountRate;
	
	@ManyToOne
	@JoinColumn(name = "singerId")
	private ArtistEntity singer;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderEntity> orders = new ArrayList<OrderEntity>();
	
	@Column(name = "album_type")
	private String type;
	
	@Column(name = "album_status")
	private String status;
	
	@Column(name = "album_stock_count")
	private long stockCount;
	
	@Column(name = "album_sales_count")
	private long salesCount;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date creation_date;
	
	public AlbumEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public AlbumEntity(String name, double pierce, double discountRate, String type, String status, long stockCount,
			long salesCount) {
		super();
		this.name = name;
		this.pierce = pierce;
		this.discountRate = discountRate;
		this.type = type;
		this.status = status;
		this.stockCount = stockCount;
		this.salesCount = salesCount;
	}
	
	public AlbumEntity(String name, double pierce, byte[] imgCover, double discountRate, String type, String status,
			long stockCount, long salesCount) {
		
		this.name = name;
		this.pierce = pierce;
		this.imgCover = imgCover;
		this.discountRate = discountRate;
		this.type = type;
		this.status = status;
		this.stockCount = stockCount;
		this.salesCount = salesCount;
	}
	
	@Override
	public String toString() {
		return "AlbumEntity [id=" + id + ", name=" + name + ", pierce=" + pierce + ", imgCover="
				+ Arrays.toString(imgCover) + ", discountRate=" + discountRate + ", singer=" + singer + ", type=" + type
				+ ", status=" + status + ", stockCount=" + stockCount + ", salesCount=" + salesCount + "]";
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPierce() {
		return pierce;
	}
	
	public void setPierce(double pierce) {
		this.pierce = pierce;
	}
	
	public byte[] getImgCover() {
		return imgCover;
	}
	
	public void setImgCover(byte[] imgCover) {
		this.imgCover = imgCover;
	}
	
	public double getDiscountRate() {
		return discountRate;
	}
	
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public ArtistEntity getSinger() {
		return singer;
	}
	
	public void setSinger(ArtistEntity singer) {
		this.singer = singer;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getStockCount() {
		return stockCount;
	}
	
	public void setStockCount(long stockCount) {
		this.stockCount = stockCount;
	}
	
	public long getSalesCount() {
		return salesCount;
	}
	
	public void setSalesCount(long salesCount) {
		this.salesCount = salesCount;
	}
	
	public List<OrderEntity> getOrders() {
		return orders;
	}
	
	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	
}
