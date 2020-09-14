package com.sathish.springmvc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sathish.springmvc.Model.Human;

public interface HumanRepo extends JpaRepository<Human, Integer> {

	public List<Human> findByName(String name);
	 
//	@Query("select id from human where name= :name ")
//	public List<Human> find(@Param("name") String name);

}
