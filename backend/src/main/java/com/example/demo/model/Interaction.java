package com.example.demo.model;
//import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="interactions")
public class Interaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String type; // CALL, EMAIL, MEETING
	private String date;
    
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String notes;
   // private LocalDateTime date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	 public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	 @ManyToOne
	    private Customer customer;

	    @ManyToOne
	    private Lead lead;
	    
		public Lead getLead() {
			return lead;
		}
		public void setLead(Lead lead) {
			this.lead = lead;
		}
		@Override
		public String toString() {
			return "Interaction [id=" + id + ", type=" + type + ", date=" + date + ", notes=" + notes + ", customer="
					+ customer + ", lead=" + lead + "]";
		}
		
		

}
