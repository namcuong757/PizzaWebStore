package in.nam.pizzafullstack.pizza_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pid;
	@Column(name="type")
	private String type;
	@Column(name="side")
	private String side;
	@Column(name="drink")
	private String drink;
	@Column(name="cust_name")
	private String cust_name;
	@Column(name="admin_id")
	private String admin_id;
	@Column(name="server")
	private String server;
	@Column(name="price")
	private int price;
	Pizza(){}
	public Pizza(long pid, String type, String side, String drink, String cust_name, String admin_id, String server,
			int price) {
		super();
		this.pid = pid;
		this.type = type;
		this.side = side;
		this.drink = drink;
		this.cust_name = cust_name;
		this.admin_id = admin_id;
		this.server = server;
		this.price = price;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
