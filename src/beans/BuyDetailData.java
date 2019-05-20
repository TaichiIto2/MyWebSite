package beans;

import java.io.Serializable;

public class BuyDetailData implements Serializable {

	private int id;
	private int buyId;
	private int itemId;
	private int cart_item_num;

	public int getCart_item_num() {
		return cart_item_num;
	}
	public void setCart_item_num(int cart_item_num) {
		this.cart_item_num = cart_item_num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
