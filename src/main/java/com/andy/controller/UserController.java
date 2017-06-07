package com.andy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.pojo.User;
import com.andy.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request , Model model){
		
		int userId = Integer.parseUnsignedInt(request.getParameter("id"));
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		System.out.println(user.getName());
		return "showUser";
	}
	
	@RequestMapping("insertUser")
	public String insertUser(HttpServletRequest request,Model model) {
		User user = new User();
		user.setName(request.getParameter("userName"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setPassword(request.getParameter("password"));
		int flag = userService.insertUser(user);
		System.out.println(flag);
		if (flag == 1) {
			model.addAttribute("user", user);
			return "showUser";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/getAllUsers")
	public String getAllUsers(Model model){
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "userList";
	}
}



