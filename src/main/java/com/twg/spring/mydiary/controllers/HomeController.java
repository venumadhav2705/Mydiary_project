package com.twg.spring.mydiary.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.twg.spring.mydiary.business.EntryBusinessInterface;
import com.twg.spring.mydiary.business.UserBusinessInterface;
import com.twg.spring.mydiary.entities.Entry;
import com.twg.spring.mydiary.entities.User;
@Controller
public class HomeController {
	@Autowired
	private UserBusinessInterface userBusinessInterface;
	
	@Autowired
    HttpSession session;  
	
	public UserBusinessInterface getUserBusinessInterface() {
		return userBusinessInterface;
	}

	public void setUserBusinessInterface(UserBusinessInterface userBusinessInterface) {
		this.userBusinessInterface = userBusinessInterface;
	}
	@Autowired
	private EntryBusinessInterface entryBusinessInterface;
	
	public EntryBusinessInterface getEntryBusinessInterface() {
		return entryBusinessInterface;
	}


	public void setEntryBusinessInterface(EntryBusinessInterface entryBusinessInterface) {
		this.entryBusinessInterface = entryBusinessInterface;
	}


	@RequestMapping("home")
	public ModelAndView homepage()
	{
		ModelAndView model=new ModelAndView("loginpage");  //creating object
		
		return model;
	}
	
	/*
	 * @RequestMapping("thome") public ModelAndView thomepage() { ModelAndView
	 * model=new ModelAndView("loginpage"); //creating object
	 * 
	 * return model; }
	 */
	

	@RequestMapping("register")
	public ModelAndView registrationpage()
	{
		ModelAndView model=new ModelAndView("registrationpage");  //creating object
		
		return model;
	}
	@RequestMapping(value="saveuser",method=RequestMethod.POST) //anyone not to enter data in url we are using reques method
	public ModelAndView saveuser(@ModelAttribute("user")User user)  //model attribute is used for when we enter data in register page
 	{                                                               //that data will come here as a object and key value this is done 
		                                                            //spring framework
		//code to save user details in database
      ModelAndView model=new ModelAndView("registersuccess");  //creating object
          
      userBusinessInterface.save(user);    //from here controller will contact to business and from there to dao
		
		return model;
	}
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ModelAndView authenticateuser(@ModelAttribute("User")User user) {
		
		ModelAndView model=new ModelAndView("loginpage");
		
		User user1 = userBusinessInterface.findByUsername(user.getUsername());
		
		if(user1!=null&&user.getPassword().equals(user1.getPassword())) { //checking database password and user password equal or not if equal
			                                                 //send to userhomepage
			model.setViewName("userhomepage");               //if password not matched it goes innto login page
			model.addObject("user", user1);  //sending user name to view like welcome venu
			 
			session.setAttribute("user", user1);
			/*
													 * adding our user infromation to session variable to know who is
													 * user entire app
													 */
			                                      
			List<Entry> entries=null;
			try {
				entries=entryBusinessInterface.findByUserid(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addObject("entrieslist",entries);
		}
		
		return model;
	}
	@RequestMapping("addentry")
     public ModelAndView addentry() {
		
		ModelAndView model=new ModelAndView("addentryform");
		return model;
    	 
     }
	@RequestMapping("saveentry")
    public ModelAndView saveentry(@ModelAttribute("entry")Entry entry) {
		
		ModelAndView model=new ModelAndView("userhomepage");
		
	 entryBusinessInterface.save(entry);
	 
	 User user1=(User)session.getAttribute("user");
	 
	 List<Entry> entries=null;
		try {
			entries = entryBusinessInterface.findByUserid(user1.getId()); /* retriving user entries */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
	
		return model;
}

@RequestMapping("viewentry")
public ModelAndView viewentry(@RequestParam("id")int id) {
	
	ModelAndView model=new ModelAndView("displayentry");
	
	Entry entry=entryBusinessInterface.findbyId(id);
	
	model.addObject("entry" , entry);
 
	return model;
}
@RequestMapping("userhome")
public ModelAndView userhomepage()
{
	ModelAndView model=new ModelAndView("userhomepage");  //creating object
	 User user1=(User)session.getAttribute("user");
	 List<Entry> entries=null;
		try {
			entries = entryBusinessInterface.findByUserid(user1.getId()); /* retriving user entries */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
	return model;
}
@RequestMapping("updateentry")
public ModelAndView updateentry(@RequestParam("id")int id) {
	
	ModelAndView model=new ModelAndView("displayupdateentry");
	
	Entry entry=entryBusinessInterface.findbyId(id);
	
	model.addObject("entry" , entry);
 
	return model;
	
}
@RequestMapping("processentryupdate")
public ModelAndView processentryupdate(@ModelAttribute("entry")Entry entry) {
	
	ModelAndView model=new ModelAndView("userhomepage");
	
     entryBusinessInterface.update(entry);
 
 User user1=(User)session.getAttribute("user");
 
 List<Entry> entries=null;
	try {
		entries = entryBusinessInterface.findByUserid(user1.getId()); /* retriving user entries */
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	model.addObject("entrieslist",entries);

	return model;
}

@RequestMapping("deleteentry")
public ModelAndView deleteentry(@RequestParam("id")int id) {
	
	ModelAndView model=new ModelAndView("userhomepage");
	
	Entry entry=entryBusinessInterface.findbyId(id);
	
	entryBusinessInterface.delete(entry);
	
	 User user1=(User)session.getAttribute("user");
	 List<Entry> entries=null;
		try {
			entries = entryBusinessInterface.findByUserid(user1.getId()); /* retriving user entries */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);

	
 
	return model;
	
}
@RequestMapping("signout")
public ModelAndView signout()
{
	ModelAndView model=new ModelAndView("loginpage");  //creating object
	session.invalidate(); /* session ki user information add chesinam kada adi delete avvadam kosam */
	
	return model;
}
}