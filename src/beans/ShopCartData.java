package beans;

import java.io.Serializable;

public class ShopCartData implements Serializable {
	private int id;
	private int itemId;
	private int cartitemNum;
	private int userId;

	private int price;
	private String name;
	private String fileName;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ShopCartData(int id, int price, String name, String fileName, int cartitemNum) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public ShopCartData(int id, int itemId, int price, String name, String fileName, int cartitemNum) {
		this.id = id;
		this.itemId = itemId;
		this.price = price;
		this.name = name;
		this.fileName = fileName;
		this.cartitemNum = cartitemNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCartitemNum() {
		return cartitemNum;
	}
	public void setCartitemNum(int cartitemNum) {
		this.cartitemNum = cartitemNum;
	}

}
