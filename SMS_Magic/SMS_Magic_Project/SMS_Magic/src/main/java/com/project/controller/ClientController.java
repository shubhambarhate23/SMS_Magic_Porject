package com.project.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.client;
import com.project.entity.user;
import com.project.repository.ClientRepository;
import com.project.repository.ClientUserRepository;
import com.project.repository.UserRepository;
import com.project.service.ClientService;
import com.project.service.clientUserService;
import com.project.service.userService;

@Controller
public class ClientController {

	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private ClientService cs;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private userService us;
	
	@Autowired
	private ClientUserRepository cur;
	
	@Autowired
	private clientUserService cus;
	
	@GetMapping("/register")
	public String register()
	{
		return "ClientRegister";
	}
	
	@PostMapping("/RegisterClient")
	public String CheckRegister(@ModelAttribute client client,Model model)
	{
		String name=client.getName();
		com.project.entity.client n=cs.findByName(name);
		if(n==null)
		{
		cr.save(client);
		model.addAttribute("message", "register successful");
		}
		else
		{
			model.addAttribute("message", "already regsiter");
		}
		return "ClientRegister";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "Client_Login";
	}
	
	@GetMapping("/list_appusers")
	public String showListAppUsers(HttpSession session,Model model)
	{
		String name=(String) session.getAttribute("name");
		List<user> userList1=cs.findAllByName(name);
		System.out.println(userList1);
		model.addAttribute("userList1", userList1);
		return "show_list_Appusers";
	}
	
	@PostMapping("/LoginClient")
	public String checkLogin(@RequestParam("name") String name,Model model,HttpSession session)
	{
		
		client n=cs.findByName(name);
		if(n!=null)
		{
			model.addAttribute("message", "login successful");
		}
		else
		{
			model.addAttribute("message", "details not found please register first");
		}
		session.setAttribute("name", name);
		return "redirect:/list_appusers";
	}
	
	
}
