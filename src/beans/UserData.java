package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserData implements Serializable {
	private int id;
	private String loginId;
	private String name;
	private String password;
	private String email;
	private int postcode;
	private String metropolis;
	private String districts;
	private String addres;
	private Timestamp create_date;
	private Timestamp  update_date;

	//コンストラクタ
	public UserData(int id, String loginId, String name, String password, String email, int postcode,
			String metropolis, String districts, String addres, Timestamp create_date, Timestamp  update_date) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.postcode = postcode;
		this.metropolis = metropolis;
		this.districts = districts;
		this.addres = addres;
		this.create_date = create_date;
		this.update_date = update_date;

	}

	public UserData(int id, String loginId, String name) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
	}

	public UserData() {

	}

	public UserData(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}

	public UserData(int id, String loginId, String name, Timestamp create_date) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.create_date = create_date;

	}

	public UserData(int id, String loginId, String name, String email, int postcode,
			String metropolis, String districts, String addres, Timestamp create_date, Timestamp  update_date) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.email = email;
		this.postcode = postcode;
		this.metropolis = metropolis;
		this.districts = districts;
		this.addres = addres;
		this.create_date = create_date;
		this.update_date = update_date;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getMetropolis() {
		return metropolis;
	}

	public void setMetropolis(String metropolis) {
		this.metropolis = metropolis;
	}

	public String getDistricts() {
		return districts;
	}

	public void setDistricts(String districts) {
		this.districts = districts;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Timestamp getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

}
