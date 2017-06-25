package com.pfeiffer.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfeiffer.lookify.models.Review;
import com.pfeiffer.lookify.models.Song;
import com.pfeiffer.lookify.repositories.ReviewRepository;
import com.pfeiffer.lookify.repositories.SongRepository;

@Service
public class SongService {
    private SongRepository songRepository;
    private ReviewRepository reviewRepository;
    
    public SongService(SongRepository songRepository, ReviewRepository reviewRepository){
        this.songRepository = songRepository;
        this.reviewRepository = reviewRepository;
    }

    
    public List<Song> allSongs(){
        return songRepository.findAll();
    }

    public Song findSongById(Long id) {
        return songRepository.findOne(id);
        
    }
    
    public void addSong(Song song){
    	songRepository.save(song);
    }
    
    public void addReview(Review review){
    	reviewRepository.save(review);
    }
    
    public void updateSong(Song song) {
    	songRepository.save(song);
    }
    
    public void destroySong(Long id) {
    	songRepository.delete(id);
    }
}

