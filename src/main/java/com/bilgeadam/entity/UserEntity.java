package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_surname")
	private String surname;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_phone")
	private String phone;
	@Column(name = "user_address")
	private String address;
	@Column(name = "user_status")
	private String status;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderEntity> orders = new ArrayList<OrderEntity>();
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date creation_date;
	
	public UserEntity() {
		
	}
	
	public UserEntity(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public UserEntity(String name, String surname, String email, String password, String phone, String address,
			String status) {
		
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, creation_date, email, id, name, password, phone, status, surname);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(address, other.address) && Objects.equals(creation_date, other.creation_date)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(status, other.status) && Objects.equals(surname, other.surname);
	}
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", address=" + address + ", status=" + status + "]";
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
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
