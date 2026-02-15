package com.hagag.springmvcboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
	
	
	String aname;
	
	@Id
	int aid;
	
	public Alien() {
		
	}
	public Alien(String aname, int aid) {
		super();
		this.aname = aname;
		this.aid = aid;
	}
	
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getAid() {
		return aid;
	}
	
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAname() {
		return aname;
	}
	@Override
	public String toString() {
		return "Alien [aname=" + aname + ", aid=" + aid + ",]";
	}
	

}
