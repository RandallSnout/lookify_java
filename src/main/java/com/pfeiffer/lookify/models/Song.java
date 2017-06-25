package com.pfeiffer.lookify.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="songs")
public class Song {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	@Size(min = 5)
    private String name;
	
	@Column
	@Size(min=1)
	private String artist;
	
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date created_at;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updated_at;

    @OneToMany(mappedBy="song", fetch = FetchType.LAZY)
    private List<Review> reviews;
    
    public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@PrePersist
    protected void onCreate(){
            this.setCreated_at(new Date());
    }
    @PreUpdate
    protected void onUpdate(){
            this.setUpdated_at(new Date());
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Song() {

	}
	public Song(Long id, String name, String artist, Date created_at, Date updated_at, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.reviews = reviews;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
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
