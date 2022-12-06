package com.universityproject.admin_entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;	
	
	private String nameOfProject;
	
	private String tools;
	
	@Lob
	  private byte[] file;
	
	private String guideName;
	
	private String guideExperience;
	
	private String guideQualification;
	

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;

	public StudentDetails(String nameOfProject, String tools, byte[] file, String guideName,
			String guideExperience, String guideQualification) {
		this.nameOfProject = nameOfProject;
		this.tools = tools;
		this.file = file;
		this.guideName = guideName;
		this.guideExperience = guideExperience;
		this.guideQualification = guideQualification;
	
	}
	
	public StudentDetails()
	{
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfProject() {
		return nameOfProject;
	}

	public void setNameOfProject(String nameOfProject) {
		this.nameOfProject = nameOfProject;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public String getGuideExperience() {
		return guideExperience;
	}

	public void setGuideExperience(String guideExperience) {
		this.guideExperience = guideExperience;
	}

	public String getGuideQualification() {
		return guideQualification;
	}

	public void setGuideQualification(String guideQualification) {
		this.guideQualification = guideQualification;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	//@Override
//	public String toString() {
//		return "StudentDetails [id=" + id + ", nameOfProject=" + nameOfProject + ", tools=" + tools + ", file="
//				+ Arrays.toString(file) + ", guideName=" + guideName + ", guideExperience=" + guideExperience
//				+ ", guideQualification=" + guideQualification + ", student=" + student + "]";
//	}


}
