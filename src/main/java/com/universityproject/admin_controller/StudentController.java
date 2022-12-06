package com.universityproject.admin_controller;

import java.io.IOException;
import java.util.Optional;

import org.eclipse.jdt.internal.compiler.env.IBinaryNestedType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.universityproject.admin_dao.StudentDAO;
import com.universityproject.admin_dao.StudentDetailsDAO;
import com.universityproject.admin_entity.Student;
import com.universityproject.admin_entity.StudentDetails;
@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentDAO studentDAO;
	@Autowired
	StudentDetailsDAO studentDetailsDAO;
	
	@RequestMapping("/home")
	public String login()
	{
		return "student/student-login";
	}
	
	@RequestMapping("/check")
	public String check(@RequestParam("rollNo")int rollNo,Model theModel)
	{
		Optional<Student> student=studentDAO.findById(rollNo);
		Student theStudent=null;
		if(!student.isPresent())
		{
			theModel.addAttribute("data", false);
			System.out.println("invalid id");
			return "student/student-login";
		}
		theStudent=student.get();
		System.out.println("yes: "+theStudent.getStudentDetails());
		if(theStudent.getStudentDetails()!=null)//student has submitted synopsis
		{  //student has filled the synopsis and he is revisiting the status of synopsis again
			Boolean submitted=theStudent.isSubmitted();
			Boolean approval=theStudent.isApproval();
			Boolean pending=theStudent.isPending();
//			String feedback = theStudent.getFeedback();
			int  status=0;
			if(pending==true &&approval==false)
				status=1;
			else if(pending==false &&approval==true)
				status=2;
			else if(pending==false && approval==false)
				status=3;
			theModel.addAttribute("status", status);
			theModel.addAttribute("student", theStudent);
			return "student/confirmation-page";
		}
		StudentDetails studentDetails=new StudentDetails();
		theModel.addAttribute("studentDetails",studentDetails);
		theModel.addAttribute("student", theStudent);
		return "student/student-details-form";
	}
	@RequestMapping("/addStudentDetails")
	public String addStudentDetails(@RequestParam("file1")MultipartFile file,  @RequestParam("studentId")int studentId,@ModelAttribute("studentDetails")StudentDetails studentDetails,Model theModel) throws IOException
	{
		System.out.println("studentId is:"+studentId);
		System.out.println("studentdetailForm filled successfully");
		System.out.println(file.getContentType());
		byte[] data=file.getBytes();
		studentDetails.setFile(data);
		System.out.println("data is"+data);
		Optional<Student> student =studentDAO.findById(studentId);
		Student theStudent=student.get();
		if(theStudent.getStudentDetails()==null)//taki agar vapis bhare toh duplicate data na aaye 
		{//student details table mai
			theStudent.setStudentDetails(studentDetails);
			studentDetails.setStudent(theStudent);

		}		
		theStudent.setSubmitted(true);
		theStudent.setApproval(false);
		theStudent.setPending(true);
		theModel.addAttribute("student",theStudent);
		System.out.println("student linked is : "+studentDetails.getStudent());
	    //studentDetailsDAO.save(studentDetails);
		studentDAO.save(theStudent);//student updated
		return "student/confirmation-page";
	}
	@RequestMapping("/approvedOrNot")
	@ResponseBody
	public boolean approvedOrNot(@RequestParam("feedback")String feedback,@RequestParam("data") boolean data,@RequestParam("studentId")int id)
	{
		System.out.print("in approvedornot");
		System.out.println("studentId"+id);
		System.out.println("feedback"+feedback);
			Optional<Student> student=studentDAO.findById(id);
			Student theStudent=student.get();
			theStudent.setApproval(data);
			theStudent.setPending(false);
			theStudent.setFeedback(feedback);
			studentDAO.save(theStudent);
		System.out.println(data);
		return data;
	}
	@RequestMapping("/resubmit")
	public String resubmit(@RequestParam("studentId")int studentId,Model theModel)
	{
		Optional<Student> student=studentDAO.findById(studentId);
		Student theStudent=student.get();
		theStudent.setStudentDetails(null);
		StudentDetails studentDetails=new StudentDetails();
		theModel.addAttribute("studentDetails",studentDetails);
		theModel.addAttribute("student", theStudent);
        return "student/student-details-form";
	}
 }
