package com.pfeiffer.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfeiffer.lookify.models.Song;
import com.pfeiffer.lookify.models.Review;
import com.pfeiffer.lookify.services.SongService;

@Controller
public class Songs {
	private final SongService songService;
    public Songs(SongService songService){
        this.songService = songService;
    }
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping("/dashboard")
    public String songs(Model model) {
        List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
    
    @RequestMapping("/song/{index}")
    public String findSongByIndex(@PathVariable("index") Long index, Model model, @ModelAttribute("review") Review review) {
    	Song s = songService.findSongById(index);
        model.addAttribute("song", s);
        model.addAttribute("reviews", s.getReviews());
        return "songReviews.jsp";
    }
    
    @RequestMapping("/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "newSong.jsp";
    }

    @PostMapping("/new")
    public String createSong(
            @Valid @ModelAttribute("song") Song song, 
            BindingResult result ) {
        if (result.hasErrors()) {
            return "redirect:/new";
        }else{
            songService.addSong(song);
            String songId = Long.toString(song.getId());
            System.out.println(songId);
            return "redirect:/song/" + songId;
        }
    }
    
    @PostMapping("/newReview/{songId}")
    public String createReview(
            @Valid @ModelAttribute("review") Review review, @ModelAttribute("song") Song song,
            BindingResult result, @PathVariable("songId") int songId){
        if (result.hasErrors()) {
            return "redirect:/song/{songId}";
        }else{
        	System.out.println("In the controller" + review.getId());
            songService.addReview(review);
            return "redirect:/song/{songId}";
        }
    }
    
    @PostMapping("/edit/{id}")
    public String updateSong(
            @Valid Song song,
            BindingResult result, 
            @PathVariable("id") int id) {
        if (result.hasErrors()) {
            return "editSong";
        }else{
            songService.updateSong(song);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping("/edit/{id}")
    public String editSong(
        @PathVariable("id") Long id,
        Model model) {
        Song song = songService.findSongById(id);
        if (song != null){
            model.addAttribute("song", song);
            return "editSong";
        }else{
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping(value="/delete/{id}")
    public String destroySong(@PathVariable("id") Long id) {
        songService.destroySong(id);
        return "redirect:/dashboard";
    }
}
