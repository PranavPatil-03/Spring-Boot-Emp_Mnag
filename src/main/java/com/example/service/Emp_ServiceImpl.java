package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.entity.Emp_Entity;
import com.example.repostary.Emp_Reposatory;

import jakarta.servlet.http.HttpSession;

@Service
public class Emp_ServiceImpl implements Emp_Service{
	
	@Autowired
	private Emp_Reposatory emp_Repo;

	@Override
	public Emp_Entity saveEmp(Emp_Entity emp) {
		
		Emp_Entity save= emp_Repo.save(emp);
		
		return save;
	}

	@Override
	public List<Emp_Entity> getAllEmp_Emp() {
		
		return emp_Repo.findAll();
	}

	@Override
	public Emp_Entity getEmpById(int id) {
	
		return emp_Repo.findById(id).get();
	}

	@Override
	public boolean deletEmp(int id) {
	  Emp_Entity emp= emp_Repo.findById(id).get();
	  
	  if(emp!=null) {
		  emp_Repo.delete(emp);
		  return true;
	  }
	  
		return false;
	}
        public void removeSessionMessage() {
        	HttpSession session=((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest()
        			.getSession();
        	session.removeAttribute("msg");
        }
	

	
}
