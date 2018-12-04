package com.aman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;  

	@Controller  
	public class EmpController {  
			    
    @RequestMapping(value="/saveAction")  
    public ModelAndView save(@RequestParam("id") int id, @RequestParam("name") String name){  
    	Emp emp = new Emp();
    	emp.setId(id);
    	emp.setName(name);
    
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("viewemp");
    	mv.addObject("empObj",emp);
    	return mv;
    }
}