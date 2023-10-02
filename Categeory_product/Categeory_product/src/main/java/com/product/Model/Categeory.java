package com.product.Model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;


	@Entity
	@EntityListeners(AuditingEntityListener.class)
    public class Categeory {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column(nullable = false)
		@Size(min =2,max = 10,message = "type must contain between 2 to 10 characters")

		private String Type;
		
		@Column(nullable = false)
		@Size(min =2,max = 10,message = "Description should contain between 3 to 30 characters")
        private String Description;
		
		@Column(nullable = false)
	 	private String Rating ;
		
		@CreatedDate
		private Instant CreatedAt;
		
		@LastModifiedDate
		private Instant UpdatedAt;
		
		@OneToMany(mappedBy = "category")
        private  List<Product> product;
		
		
		public Categeory() {}


		public Categeory(int id, String type, String description, String rating, Instant createdAt, Instant updatedAt) {
		
			this.id = id;
			this.Type = type;
			this.Description = description;
			this.Rating = rating;
			this.CreatedAt = createdAt;
			this.UpdatedAt = updatedAt;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getType() {
			return Type;
		}


		public void setType(String type) {
			Type = type;
		}


		public String getDescription() {
			return Description;
		}


		public void setDescription(String description) {
			Description = description;
		}


		public String getRating() {
			return Rating;
		}


		public void setRating(String rating) {
			Rating = rating;
		}


		public Instant getCreatedAt() {
			return CreatedAt;
		}


		public void setCreatedAt(Instant createdAt) {
			CreatedAt = createdAt;
		}


		public Instant getUpdatedAt() {
			return UpdatedAt;
		}


		public void setUpdatedAt(Instant updatedAt) {
			UpdatedAt = updatedAt;
		}


		
}
