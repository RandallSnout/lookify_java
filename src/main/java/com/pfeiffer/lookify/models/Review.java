package com.pfeiffer.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="reviews")
public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column
	@Size(min=1)
	private String body;
	
	@Column
	@Max(10)
	@Min(1)
	private int rating;
	
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date created_at;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="song_id")
    private Song song;
    
    public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	@PrePersist
    protected void onCreate(){
            this.setCreated_at(new Date());
    }
    @PreUpdate
    protected void onUpdate(){
            this.setUpdated_at(new Date());
    }
    public Review() {
    }
	public Review(Long id, String body, int rating, Date created_at, Date updated_at, Song song) {
		this.id = id;
		this.body = body;
		this.rating = rating;
		this.created_at = new Date();
		this.updated_at = new Date();
		this.song = song;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
    
}
