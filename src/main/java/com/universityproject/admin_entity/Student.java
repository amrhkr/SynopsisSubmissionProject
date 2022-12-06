package com.universityproject.admin_entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.universityproject.admin_dao.EvaluatorDAO;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade= {CascadeType.ALL})
	@JoinColumn(name = "eval_id")
	private Evaluator evaluator;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "student")
	StudentDetails studentDetails;
	
	@Transient
	private String evaluatorId=null;
	
	
	private boolean submitted;
	
	private boolean approval;
	
	private boolean pending;
	
	private String feedback;
	
	public Student()
	{
		pending=false;
		approval=false;
	}

	public Student(int id, String name, Evaluator evaluator, String feedback) {
		this.id = id;
		this.name = name;
		this.evaluator = evaluator;
		this.feedback = feedback;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Evaluator getEvaluator() {
		System.out.println("in get evaluator");
		return evaluator;
	}
	
	

	public void setEvaluatorId(String evaluatorId) {
	   this.evaluatorId=evaluatorId;
	}

	public String getEvaluatorId() {
		return evaluatorId;
	}

	public void addEvaluator(Evaluator evaluator)
	{
		this.evaluator=evaluator;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", evaluator=" + evaluator + ", studentDetails="
				+ studentDetails + ", evaluatorId=" + evaluatorId + ", submitted=" + submitted + ", approval="
				+ approval + ", pending=" + pending + ", feedback=" + feedback + "]";
	}
	
	
}
