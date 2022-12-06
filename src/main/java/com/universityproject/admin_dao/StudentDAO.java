package com.universityproject.admin_dao;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universityproject.admin_entity.Student;
@Transactional
public interface StudentDAO extends JpaRepository<Student, Integer> {

	Map map=new HashMap<>();
	
}
