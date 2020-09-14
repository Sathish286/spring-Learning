package com.sathish.springmvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sathish.springmvc.DAO.HumanDAO;
import com.sathish.springmvc.Model.Human;
//in normal mvc project when client send an request the request need to be handled by dispatcher Servlet
//and we have configured dispatcher servlet in web.xml file using servlet tags and once after configuring 
//dispatcher servlet the request has to be mapped towards the controller to do so we are adding another
//xml configuration in web-inf folder there we specify the package to be scanned by spring and
//and tell spring i.e annotation based configuration once doing that request will be mapped by
//the dispatcher servlet to controller
@Controller
public class HomeController {
	
	//COMMENTED LINES WILL ALSO WORK BUT FOR LEARNING PURPOSE COMMENTED OUT BEACAUSE ALL THE METHODS ARE SAME WITH DIFFERENT IMPLEMENTATION
	
	@Autowired
	HumanDAO humanDao;
	
	//here for empty path the request has to be mapped to this method by using requestmapping annotation
	//and specifying the path. you might notice the return value is string which is nothing the view page name
	//which is index.jsp but .jsp is missing here right? this is where i have specified the suffix in
	//sathish-servlet.xml and there will be an prefix too the need for prefix is when it sees the return
	//value has jsp  file it will look for file in webapp but look there we have add jsp files inside
	//the views folder so we are adding preffix there and internalviewresolver job is to find the view page and add 
	//extension to it.
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
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,Model m) {
		
		
		int num3 = i+j;
		m.addAttribute("num3", num3);
		return "result";
		
	}
	
	@ModelAttribute
	public String name(Model m)
	{
		m.addAttribute("name","Sathish");
		return "result";
	}
	
	
	@RequestMapping("addHuman")
	public String add(@ModelAttribute("human") Human human) {
		//System.out.println(human.getName());
		return "result";
		
	}
	
	@GetMapping("getHumans")
	public String getHumans(Model m) {
		
//		List<Human> humans = Arrays.asList(new Human(1,"sathish"),new Human(2,"dhoni"));
		
	
		m.addAttribute("humans",humanDao.getAllHumans());
		return "getHumans";
	}
	
//	@RequestMapping("addHuman")
//	public String add(@RequestParam("id") int i,@RequestParam("name") String name,Model m)
//	{
//			m.addAttribute("id",i);
//			m.addAttribute("name",name);
//			return "result";
//	}
//	@RequestMapping("addHuman")
//	public ModelAndView add(@RequestParam("id") String id,@RequestParam("name") String name) {
//		
//		int id1=Integer.parseInt(id);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		mv.addObject("id" ,id1);
//		mv.addObject("name" ,name);
//		return mv;
//		
//	}
	
}
