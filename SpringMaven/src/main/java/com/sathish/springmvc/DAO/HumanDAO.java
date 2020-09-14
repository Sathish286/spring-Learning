package com.sathish.springmvc.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathish.springmvc.Model.Human;


@Component
public class HumanDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public List<Human> getAllHumans()
	{
		Session session = sessionFactory.getCurrentSession();
		List<Human> humans = session.createQuery("from human", Human.class).list();
		return humans;
	}

}
