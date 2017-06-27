package org.krd.khmer.controller;

import java.util.ArrayList;
import java.util.List;

import org.krd.khmer.model.User;
import org.krd.khmer.service.UserService;
import org.krd.khmer.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {
	
	UserService userService;
	List<User> users = new ArrayList<>();
	
	@Autowired
	public MainController(UserServiceImpl userServiceImpl) {
		// TODO Auto-generated constructor stub
		this.userService = userServiceImpl;
		
	}

    @RequestMapping({"/", "/dashboard"})
    public String homePage(ModelMap modelMap) {
    	int totalUser= userService.countTotal();
    	int totalMale= userService.countMale();
    	int totalFemale = userService.countFemale();
    	int totalUserfales = userService.countUserfales();
    	
    	modelMap.addAttribute("TOTALUSER", totalUser);
    	modelMap.addAttribute("TOTALMALE", totalMale);
    	modelMap.addAttribute("TOTALFEMALE", totalFemale);
    	modelMap.addAttribute("TOTALUSERFALSE", totalUserfales);
    	
    	
        return "dashboard";
    }
   
    @RequestMapping("/user")
    public String userPage(ModelMap model) {
    	model.addAttribute("user",new User());
    	model.addAttribute("addStatus", true);
        return "User";  
    }
    
    @PostMapping("/usersave")
    public String getFormData(@ModelAttribute("user") User user, ModelMap mop){
		mop.addAttribute("user", userService.save(user));
    	return "redirect:userlist";
    	
    }
    @RequestMapping("/userlist")
    public String userListPage(ModelMap model) {
    	users = userService.findAll();
    	model.addAttribute("USERS", users);
        return "/userlist";
    }

    
    @GetMapping("/edit{user_hash}")
    public String edit(ModelMap model, @RequestParam("user_hash") String user_hash){
		User user=userService.findone(user_hash);
		model.addAttribute("user", user);
		model.addAttribute("addStatus", false);
		System.out.println("USER HASH at Edit " + user.getUser_hash());
    	return "User";	
    }
    @RequestMapping("/update")
    public String update( @ModelAttribute("user") User user){
    	
    	System.out.println("USER HASH at udpate " + user.getUser_hash());
    	if(userService.update(user)){
    		System.out.println("Update Successfully");
    	}else{
    		System.out.println("Error");
    	}
    	return "redirect:/userlist"; 
    }
    @GetMapping("/detail{user_hash}")
    public String String (ModelMap model, @RequestParam("user_hash") String user_hash){
		User user=userService.detail(user_hash);
		model.addAttribute("user_detail", user);
		model.addAttribute("addStatus", false);
    	return "user_detail";	
    }
    
    @GetMapping("/remove{user_hash}")
    public String delete(@ModelAttribute("user_hash") String user_hash){
    	System.out.println(user_hash);
    	if(userService.delete(user_hash)){
    		System.out.println("Delete Success");
    	} else {
    		System.out.println("Delete not Success");
    	}
    	return "redirect:userlist";
    }
    
    @RequestMapping("/role")
    public String rolePage() {
        return "/role";
    }
    @RequestMapping("/rolelist")
    public String roleListPage() {
        return "rolelist";
    }
    @RequestMapping("/userdetail")
    	public String detailPage(){
    		
    	return "user_detail";
    }

    







   



}
