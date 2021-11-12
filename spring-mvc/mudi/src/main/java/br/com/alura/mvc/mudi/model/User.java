package br.com.alura.mvc.mudi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	private String username;

	@OneToMany(
		cascade = CascadeType.ALL,
		mappedBy = "user",
		fetch = FetchType.LAZY
	)
	private List<Order> orders = new ArrayList<>();

	private String password;
	private String enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
