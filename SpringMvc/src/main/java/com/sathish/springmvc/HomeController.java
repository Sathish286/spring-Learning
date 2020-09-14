package com.sathish.springmvc;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sathish.springmvc.Model.Human;
import com.sathish.springmvc.Repository.HumanRepo;


@RestController
public class HomeController {
	
	
	@Autowired
	HumanRepo repo;
	
	@RequestMapping("/")
	public String Home() {
		
		return "index";
	}
	
//	@RequestMapping("add")
//	public String add(HttpServletRequest req)
//	{
//		int num1 = Integer.parseInt(req.getParameter("num1"));
//		int num2 = Integer.parseInt(req.getParameter("num2"));
//		int num3 = num1+num2;
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("num3", num3);
//		return "result.jsp";
//	}
//	@RequestMapping("add")
//	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,HttpSession session) {
//		
//		int num3 = i+j;
//		session.setAttribute("num3", num3);
//		return "result.jsp";
//		
//	}
	
//	@RequestMapping("add")
//	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j) {
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result.jsp");
//		int num3 = i+j;
//		mv.addObject("num3" ,num3);
//		return mv;
//		
//	}
	
//	@RequestMapping("add")
//	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j) {
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		int num3 = i+j;
//		mv.addObject("num3" ,num3);
//		return mv;
//		
//	}
	
//	@RequestMapping("add")
//	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,Model m) {
//		
//		
//		int num3 = i+j;
//		m.addAttribute("num3", num3);
//		return "result";
//		
//	}
	
	@ModelAttribute
	public String name(Model m)
	{
		m.addAttribute("name","Sathish");
		return "result";
	}
	
//	@PostMapping("addHuman")
//	public String add(@ModelAttribute() Human human) {
//		
//		repo.save(human);
//		return "result";
//		
//	}
	
//	@GetMapping("getHumans")
//	public String getHumans(Model m) {
//		
////		List<Human> humans = Arrays.asList(new Human(1,"sathish"),new Human(2,"dhoni"));
//		m.addAttribute("humans",repo.findAll());
//		return "getHumans";
//	}
	
	@GetMapping("getHuman")
	public String getHuman(@RequestParam("id") int id,Model m)
	{
		m.addAttribute("humans",repo.findById(id).toString() );
		return "getHumans";
	}
	@GetMapping("getHumanByName")
	public String getHuman(@RequestParam String name,Model m)
	{
		m.addAttribute("humans",repo.findByName(name) );
		return "getHumans";
	}
//	@GetMapping("getHumanByName")
//	public String getHuman(@RequestParam String name,Model m)
//	{
//		m.addAttribute("humans",repo.find(name) );
//		return "getHumans";
//	}
	
	@GetMapping("getHumans")
	//@ResponseBody
	public List<Human> getHumans(Model m) {
		
//		List<Human> humans = Arrays.asList(new Human(1,"sathish"),new Human(2,"dhoni"));
		//m.addAttribute("humans",repo.findAll());
		List<Human> humans =repo.findAll();
		return humans;
	}
	
	@GetMapping("getHuman/{aid}")
	//@ResponseBody
	public Human getHuman(@PathVariable("aid") int id)
	{
		Human human = repo.findById(id).orElse(new Human(0,""));
		return human;
	}
	
	@PostMapping(path="addHuman",consumes=MediaType.APPLICATION_XML_VALUE)
	public Human addHuman(@RequestBody Human human)
	{
		repo.save(human);
		return human;
	}
}
