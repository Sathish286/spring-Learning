package com.sathish.springmvc;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sathish.springmvc.Model.Human;

@Aspect
@Component
public class AspectLog {

	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AspectLog.class);
	
	@Before("execution(public * com.sathish.springmvc.HomeController.getHumans())")
	public void log()
	{
		LOGGER.info("logger called");
		System.out.print("from the logging xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
}
