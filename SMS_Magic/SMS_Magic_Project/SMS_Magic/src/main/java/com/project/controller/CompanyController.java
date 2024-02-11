package com.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Company;
import com.project.entity.client;
import com.project.repository.CompanyRepository;
import com.project.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyRepository cr1;
	
	@Autowired
	private CompanyService cs1;
	
	@GetMapping("/Cregister")
	public String register()
	{
		return "CompanyRegister";
	}
	
	@PostMapping("/RegisterCompany")
	public String CheckRegister(@ModelAttribute Company company,Model model)
	{
		String name=company.getName();
		System.out.println(name);
		Company n=cs1.findByName(name);
		if(n==null)
		{
			System.out.println("null");
		cr1.save(company);
		model.addAttribute("message", "register successful");
		}
		else
		{
			model.addAttribute("message", "already regsiter");
		}
		return "CompanyRegister";
	}
	
	@GetMapping("/Clogin")
	public String login()
	{
		return "Company_Login";
	}
	
	@PostMapping("/LoginCompany")
	public String checkLogin(@RequestParam("name") String name,Model model)
	{
		
		Company n=cs1.findByName(name);
		if(n!=null)
		{
			model.addAttribute("message", "login successful");
		}
		else
		{
			model.addAttribute("message", "details not found please register first");
		}
		return "Company_Login";
	}
}
