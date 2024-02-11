package com.project.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.client;
import com.project.entity.clientUsers;
import com.project.entity.user;
import com.project.repository.ClientRepository;
import com.project.repository.ClientUserRepository;
import com.project.repository.UserRepository;
import com.project.service.ClientService;
import com.project.service.clientUserService;
import com.project.service.userService;

@Controller
public class userController {
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private userService us;
	
	@Autowired
	private ClientUserRepository cur;
	
	@Autowired
	private clientUserService cus;
	
	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private ClientService cs;
	
	
	@GetMapping("/uregister")
	public String register()
	{
		return "userRegister";
	}
	
	/*@GetMapping("/accessClientApp")
	public String viewApps()
	{
		return "/accessClientApp";
	}*/
	
	@PostMapping("/User_register")
	public String CheckRegister(@ModelAttribute user user,HttpSession session ,Model model)
	{
		String name=user.getUsername();
		com.project.entity.user n=us.findByUsername(name);
		System.out.println(n);
		
		if(n==null)
		{
			ur.save(user);
			System.out.println("role "+user.getRole());
			model.addAttribute("message", "register successful");
			if(user.getRole()=="App_USER")
			{
				clientUsers clientuser=new clientUsers();
				clientuser.setUser(user);
				cur.save(clientuser);
			}
			
		}
		else
		{
			model.addAttribute("message", "already regsiter");
			
		}
		return "userRegister";
		
	}
	
	@GetMapping("/ulogin")
	public String login()
	{
		return "UserLogin";
	}
	
	
	@GetMapping("/App_user_dashboard")
	public String app_user_dashboard()
	{
		return "App_user_dashboard";
	}
	
	@PostMapping("/LoginUser")
	public String checkLogin(@RequestParam("name") String name,Model model,HttpSession session)
	{
		
		user n=us.findByUsername(name);
		System.out.println(n);
		//long id=n.getId();
		
		if(n!=null)
		{
			long id_user=n.getId();
			session.setAttribute("id_user",id_user);
			//model.addAttribute("message", "login successful");
			if(n.getRole().equals("App_USER"))
			{
				//System.out.println("inside app user");
				/*List<client> clientList=cr.findAll();
				model.addAttribute("clientlist", clientList);*/
				
			}
			
			return "App_user_dashboard";
		}
		else
		{
			model.addAttribute("message", "details not found please register first");
			return "UserLogin";
		}
		
	}
	
	@GetMapping("/accessClientApp")
	public String View_Apps_From_Clients(HttpSession session,Model model)
	{
		long id=(long) session.getAttribute("id_user");
		session.setAttribute("id", id);
		List<client> clientList=cr.findAll();
		model.addAttribute("clientlist", clientList);
		return "Access_App_From_Clients";
	}
	
	@PostMapping("/accessedAppByUser")
	public String accessedRecordAddToUserList(@RequestParam("id") String id,Model model,HttpSession session)
	{
	
		System.out.println(id);
		long id_Maintain_session=(long) session.getAttribute("id");
		clientUsers clientusers=new clientUsers();
		long client_id=Integer.parseInt(id);
		Optional<client> client=cr.findById(client_id);
		clientusers.setClient(client.get());
		Optional<user> u=ur.findById(id_Maintain_session);
		user user=u.get();
		clientusers.setUser(user);
		LocalDateTime currentTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(currentTime);
		clientusers.setCreatedAt(timestamp);
		if(clientusers.getClient()!=null && clientusers.getUser()!=null)
		{
			clientusers.setActive(true);
		}
		cur.save(clientusers);
		
		//session.setAttribute("client_id", client_id);
		return "redirect:/accessClientApp";
	}
	
	@GetMapping("/view_accessed_apps")
	public String viewAccessedApp(HttpSession session,Model model)
	{
		
		long id=(long) session.getAttribute("id");
		System.out.println(id);
		session.setAttribute("id",id);
		List<clientUsers> clientUsersList=cus.findAllByuser_id(id);
		List<client> clientList =new ArrayList();
		for(clientUsers clientUsers: clientUsersList)
		{
			clientList.add(clientUsers.getClient());
		}
		model.addAttribute("clientList", clientList);
		return "view_accessed_apps";
	}
	
	

}
