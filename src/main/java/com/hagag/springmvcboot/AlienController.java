package com.hagag.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hagag.springmvcboot.model.Alien;


@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping("aliens")
	public List<Alien> getAliens() {
		
		List<Alien> aliens = repo.findAll();
		
	
	
		return aliens;
	}
	
	 @GetMapping("alien/{aid}")
	 public Alien getAlien(@PathVariable("aid") int aid) {
		 
		 Alien alien = repo.findById(aid).orElse(new Alien("", 0));

		 
		 
		 return alien;
	 }
	 
	 
	 @PostMapping("alien")
	 public Alien addAlien(Alien alien) {
		 
		 repo.save(alien);
		 return alien;
	 }

}
