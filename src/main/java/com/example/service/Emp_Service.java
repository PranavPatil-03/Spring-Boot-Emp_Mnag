package com.example.service;

import java.util.List;

import com.example.entity.Emp_Entity;

public interface Emp_Service {

	public Emp_Entity saveEmp(Emp_Entity emp);
	
	public List<Emp_Entity> getAllEmp_Emp();
	
	public  Emp_Entity getEmpById(int id);
	
	public boolean deletEmp(int id);
}
