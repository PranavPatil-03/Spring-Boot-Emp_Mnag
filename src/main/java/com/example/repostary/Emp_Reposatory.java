package com.example.repostary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Emp_Entity;


public interface Emp_Reposatory extends JpaRepository<Emp_Entity, Integer>{

}
