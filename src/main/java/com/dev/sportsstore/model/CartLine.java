package com.dev.sportsstore.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cartline")
public class CartLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_line_id")
	private Long cartLineId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "cart_id")
	private long cartId;
	
	@OneToOne()
	@JoinColumn(name = "productId", unique=true, nullable=false, updatable=false)
	private Product product;

}
