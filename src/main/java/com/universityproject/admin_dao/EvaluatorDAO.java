package com.universityproject.admin_dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.universityproject.admin_entity.Evaluator;
@Transactional
public interface EvaluatorDAO extends JpaRepository<Evaluator, Integer> {

	@Modifying
	@Query("update Evaluator eval set eval.name = ?1 where eval.id = ?2")
	void setEvalInfoById(String name, Integer userId);
}
