package com.sathish.springmvc.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Human {
	
	
	@Id
	private int id;
	public Human() {
		
	}

	private String  name;
	
	
	public Human(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Human [id=" + id + ", name=" + name + "]";
	}

}
