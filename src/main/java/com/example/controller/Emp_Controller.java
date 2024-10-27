package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Emp_Entity;
import com.example.service.Emp_Service;


import jakarta.servlet.http.HttpSession;

@Controller
public class Emp_Controller {
	
	@Autowired
	private Emp_Service emp_Service;
	
	@GetMapping("/")
	public String index(Model m) {
		List<Emp_Entity> list = emp_Service.getAllEmp_Emp();
		
	   m.addAttribute("empList",list);
	
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		
		
		return null;
		
	}
	
	@GetMapping("/loadEmpSave")
	public String loadEmpSave() {
		
		return "emp_save";
	}
	
	@GetMapping("/EditEmp/{id}")
	public String editEmpSave(@PathVariable int id ,Model m) {
		//System.out.println(id);
		Emp_Entity emp = emp_Service.getEmpById(id);
		m.addAttribute("emp",emp);
		return "emp_edit";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Emp_Entity emp,HttpSession session) {
		//System.out.println(emp);
		
		Emp_Entity newemp= emp_Service.saveEmp(emp);
		if(newemp!=null) {
		 session.setAttribute("msg", "Register Sucesssully");
			
			//System.out.println("Emp save success");
		}
		else {
			session.setAttribute("msg", "Something With Wrong");
			//System.out.println("Something With Wrong");
		}
		return "redirect:/loadEmpSave";
	}
	
	@PostMapping("/updateEmpDtls")
	public String updateEmp(@ModelAttribute Emp_Entity emp,HttpSession session) {
		//System.out.println(emp);
		
		Emp_Entity updateemp= emp_Service.saveEmp(emp);
		if(updateemp!=null) {
		 session.setAttribute("msg", "Emp Updated Sucesssully");
			
			//System.out.println("Emp save success");
		}
		else {
			session.setAttribute("msg", "Something With Wrong");
			//System.out.println("Something With Wrong");
		}
		return "redirect:/";
	}
	
	@GetMapping("/deletEmp/{id}")
	public String loadEmpSave(@PathVariable int id,HttpSession  session) {
		
		boolean b = emp_Service.deletEmp(id);
		if(b) {
			session.setAttribute("msg", "Emp Delet Successfully");
		}
		else {
			session.setAttribute("msg", "Something With Wrong");
		}
		
		return "redirect:/";
	}

}
