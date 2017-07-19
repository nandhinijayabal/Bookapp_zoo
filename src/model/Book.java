package model;


import java.sql.Date;
import java.time.LocalDate;

public class Book {
	
	private int id;
	private String name;
	private float price;
	private LocalDate pub_date;
	private int author_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getPub_date() {
		return pub_date;
	}
	public void setPub_date(LocalDate pub_date) {
		this.pub_date = pub_date;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id2) {
		this.author_id = author_id2;
	}
	@Override
	public String toString() {
		return "bookmodel [id=" + id + ", name=" + name + ", price=" + price + ", pub_date=" + pub_date + ", author_id="
				+ author_id + "]";
	}

		
	}



