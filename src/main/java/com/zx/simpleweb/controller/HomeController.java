package com.zx.simpleweb.controller;


import org.springframework.stereotype.Controller;    
   
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//home“≥√Ê
@Controller    
public class HomeController {    
    
    @RequestMapping(value="/home.do")    
    public ModelAndView home_jsp(){ 
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("welcome","Hellow£¨please write your name,then click save.You'll see a miracle!");
		return mav;
    }    
}   
