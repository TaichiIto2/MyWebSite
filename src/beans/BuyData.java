package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class BuyData implements Serializable {
	private int id;
	private int userId;
	private int itemId;
	private int price;
	private String fileName;
	private String name;
	private int cartitemNum;
	private int totalPrice;

	private int deliveryMethodId;
	private Timestamp buyDate;

	private String deliveryMethodName;
	private int deliveryMethodPrice;

	private int buyId;


	public BuyData(int id, int totalPrice, Timestamp buyDate, int deliveryMethodId, int userId,
			int deliveryMethodPrice, String deliveryMethodName) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.buyDate = buyDate;
		this.deliveryMethodId = deliveryMethodId;
		this.userId = userId;
		this.deliveryMethodPrice = deliveryMethodPrice;
		this.deliveryMethodName = deliveryMethodName;
	}

	public BuyData() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public BuyData(int id, int totalPrice, Timestamp buyDate, int deliveryMethodId, int deliveryMethodPrice,
			String deliveryMethodName) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.buyDate = buyDate;
		this.deliveryMethodId = deliveryMethodId;
		this.deliveryMethodPrice = deliveryMethodPrice;
		this.deliveryMethodName = deliveryMethodName;
	}

	public BuyData(int id, int price, int itemId, String name, int buyId, String fileName,
			int cartitemNum) {
		this.id = id;
		this.price = price;
		this.itemId = itemId;
		this.name = name;
		this.buyId = buyId;
		this.fileName = fileName;
		this.cartitemNum = cartitemNum;
	}

	public int getCartitemNum() {
		return cartitemNum;
	}
	public void setCartitemNum(int cartitemNum) {
		this.cartitemNum = cartitemNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getDeliveryMethodId() {
		return deliveryMethodId;
	}
	public void setDeliveryMethodId(int deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}
	public Timestamp getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Timestamp buyDate) {
		this.buyDate = buyDate;
	}
	public String getDeliveryMethodName() {
		return deliveryMethodName;
	}
	public void setDeliveryMethodName(String deliveryMethodName) {
		this.deliveryMethodName = deliveryMethodName;
	}
	public int getDeliveryMethodPrice() {
		return deliveryMethodPrice;
	}
	public void setDeliveryMethodPrice(int deliveryMethodPrice) {
		this.deliveryMethodPrice = deliveryMethodPrice;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getBuyId() {
		return buyId;
	}

	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}


}
