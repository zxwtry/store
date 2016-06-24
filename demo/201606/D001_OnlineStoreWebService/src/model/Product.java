package model;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private String productName;
	private String productPrice;
	private String allFiles;
	private String allBuyers;
	
	
	
	private int sellerID;
	
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public String getAllBuyers() {
		return allBuyers;
	}
	public void setAllBuyers(String allBuyers) {
		this.allBuyers = allBuyers;
	}
	public Product() {}
	public Product(String productName, String productPrice, String allFiles, int sellerID) {
		this.allFiles = allFiles;
		this.productName = productName;
		this.productPrice = productPrice;
		this.sellerID = sellerID;
		allBuyers = "";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getAllFiles() {
		return allFiles;
	}
	public void setAllFiles(String allFiles) {
		this.allFiles = allFiles;
	}
	
}
