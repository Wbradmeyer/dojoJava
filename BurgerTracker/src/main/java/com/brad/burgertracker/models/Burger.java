package com.brad.burgertracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 200, message="Burger name must be at least 3 characters.")
	private String burgerName;
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 200, message="Restaurant name must be at least 3 characters.")
	private String restaurantName;
	
	@NotNull
	@Min(value=1, message="Rating cannot be less than 1.")
	@Max(value=5, message="Rating cannot be higher than 5.")
	private Integer rating;
	
	@NotBlank
	@Size(min = 3, max = 200, message="Please add a note or write N/A.")
	private String notes;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Burger() {
	}

	public Burger(Long id,
			@NotNull @NotBlank @Size(min = 3, max = 200, message = "Burger name must be at least 3 characters.") String burgerName,
			@NotNull @NotBlank @Size(min = 3, max = 200, message = "Restaurant name must be at least 3 characters.") String restaurantName,
			@NotNull @Min(1) @Max(5) Integer rating,
			@NotBlank @Size(min = 3, max = 200, message = "Please add a note or write N/A.") String notes) {
		super();
		this.id = id;
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
