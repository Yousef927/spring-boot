package com.hagag.springmvcboot;




import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hagag.springmvcboot.model.Alien;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Hagag"); 
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home Page Requested");
		return "index";
		
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		
	
	m.addAttribute("result", repo.findAll());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam("aid") int aid , Model m) {
		if(!repo.existsById(aid)) {
			m.addAttribute("result", "Alien with id " + aid + " not found.");
			return "showAliens";
		}
		
		m.addAttribute("result", repo.getReferenceById(aid));
		
		return "showAliens";
	}
	
	@GetMapping("getAlienByName")
	public String getAlienByName(@RequestParam("aname") String aname , Model m) {
		
		List<Alien> result = repo.find(aname);
		
		if(result.isEmpty() || result == null) {
			m.addAttribute("result", "No aliens found with name " + aname + ".");
		} else {
			m.addAttribute("result", result);
		}
		
		return "showAliens";
	}
	
	
	@PostMapping("addAlien")
	public String addAlien(@ModelAttribute Alien alien) {
		repo.save(alien);
		return "result";
	}
	
	@PostMapping("deleteAlien")
	public String deleteAlien(@RequestParam("aid") int aid , Model m) {
		if(!repo.existsById(aid)) {
			m.addAttribute("result", "Alien with id " + aid + " not found.");
			return "showAliens";
		}
		Alien a = repo.getReferenceById(aid);
		repo.delete(a);
		m.addAttribute("msg", "Alien with id " + aid + " deleted successfully.");
		return "deleteAlien";
	}
	
	
	
	
	

}
