package com.universityproject.admin_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.universityproject.admin_entity.StudentDetails;

public interface StudentDetailsDAO extends JpaRepository<StudentDetails, Integer> {

	@Query(value="SELECT * FROM student_details u WHERE u.student_id = ?",nativeQuery=true)
	StudentDetails findByStudentId(int student_id);

}
