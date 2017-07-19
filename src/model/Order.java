package model;


import java.time.LocalDate;

public class Order {

	private int id;
	private int user_id;
	private int book_id;
	private int quantity;
	private String status;
	private LocalDate order_date;
	private String userName;
	private String bookName;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getOrdered_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", book_id=" + book_id + ", quantity=" + quantity
				+ ", status=" + status + ", order_date=" + order_date + ", userName=" + userName + ", bookName="
				+ bookName + "]";
	}
	
	
		
}
