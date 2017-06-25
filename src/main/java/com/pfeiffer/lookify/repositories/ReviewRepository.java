package com.pfeiffer.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfeiffer.lookify.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	List<Review> findAll();
	
	Review findOne(Long id);
}
