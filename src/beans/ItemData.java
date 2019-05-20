package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class ItemData implements Serializable {
	private int id;
	private String name;
	private String detail;
	private int price;
	private String fileName;
	private Timestamp create_date;
	private int stock;

	private int purchase_num;

	public int getPurchase_num() {
		return purchase_num;
	}
	public void setPurchase_num(int purchase_num) {
		this.purchase_num = purchase_num;
	}
	public ItemData(int id, String name, String detail, int price, String fileName, Timestamp create_date, int stock, int purchase_num) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
		this.create_date = create_date;
		this.stock = stock;
		this.purchase_num = purchase_num;
	}

	public ItemData(int id, String name, String detail, int price, String fileName, Timestamp create_date,
			int stock) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
		this.create_date = create_date;
		this.stock = stock;
	}
	public ItemData(int id, String name, int price, Timestamp create_date, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.create_date = create_date;
		this.stock = stock;
	}
	public ItemData(int id, String name, int price, String fileName) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public ItemData() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
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

}
