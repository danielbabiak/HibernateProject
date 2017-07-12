package main.java.pl;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="visit")
public class Visit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer shoppingCost;
	
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShoppingCost() {
		return shoppingCost;
	}

	public void setShoppingCost(Integer shoppingCost) {
		this.shoppingCost = shoppingCost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
