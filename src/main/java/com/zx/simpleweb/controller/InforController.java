package com.zx.simpleweb.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.zx.simpleweb.object.*;
import com.zx.simpleweb.servlet.JavawebServletContextListener;

@Controller  
public class InforController {
	/**
	 *页面跳转
	 *将guest参数传递给information页面，并判断是否为空
	 */ 
	
	@RequestMapping(value="information.do",method=RequestMethod.POST)    
	    public ModelAndView information_jsp(HttpServletRequest request){ 
			if(this.checkParams(request.getParameter("username"))){ 	
				Guest guest=new Guest();   
				guest.setName(request.getParameter("username"));
				guest.setTime();
				ModelAndView mav = new ModelAndView("information");
				mav.addObject("guest",guest);
				LDBoperate ldboperate=JavawebServletContextListener.abc;
				LDBoperate.Operate operate = ldboperate.new Operate();
				try {
					//ldboperate.create();
					
						LinkedHashMap<String,String> map=operate.displayPeople(guest);
						int num=operate.getNum();
						mav.addObject("map",map);
						mav.addObject("num",num);
					
					//ldboperate.destroy();
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return mav;
			}
			return (new ModelAndView("home")).addObject("welcome","Please write your name!");
	    }  
	 
	 
	 /***
		 * 验证参数
		 * @param params
		 * @return
		 */
		private boolean checkParams(String param){
			
				if(param==""||param==null||param.isEmpty()){
					return false;
				}
			
			return true;
		}

}
