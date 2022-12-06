package com.universityproject.admin_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.universityproject.admin_dao.EvaluatorDAO;
import com.universityproject.admin_dao.StudentDetailsDAO;
import com.universityproject.admin_entity.Evaluator;
import com.universityproject.admin_entity.Student;
import com.universityproject.admin_entity.StudentDetails;

@Controller
@RequestMapping("/evaluator")
public class EvaluatorController {

	@Autowired
	EvaluatorDAO evaluatorDAO;
	@Autowired
	StudentDetailsDAO studentDetailsDAO;
	
	@RequestMapping("/home")
	public String HomePage(Model theModel)
	{
		Evaluator evaluator=new Evaluator();
		theModel.addAttribute("evaluator", evaluator);
		return "evaluator/evaluator-home-page";
	}
	@RequestMapping("/checkLogin")
	public String Check(@ModelAttribute("evaluator") Evaluator evaluator,Model theModel)
	{
		System.out.println("evaluator id: "+evaluator.getId());
		int id_entered=evaluator.getId();
		Optional<Evaluator> theEvaluator=evaluatorDAO.findById(id_entered);
		if(theEvaluator.isPresent())
		{
			theModel.addAttribute("evaluator",theEvaluator.get());
			System.out.println(theEvaluator.get().getStudents());
			return "evaluator/show-students";
		}
		theModel.addAttribute("evaluator",evaluator);
		theModel.addAttribute("data",false);
		return "evaluator/evaluator-home-page";
	}
	
	@RequestMapping("/checkStudentDetails")
	@ResponseBody
	public ResponseEntity downloadFromDB(@RequestParam("studentDetailsId")int id) throws IOException {
		Optional<StudentDetails> studentDetails= studentDetailsDAO.findById(id);
		StudentDetails theStudentDetails=studentDetails.get();
		
		byte[] file = theStudentDetails.getFile();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "synopsis_"+theStudentDetails.getStudent().getName()+"_"+theStudentDetails.getStudent().getId()+ "\"")
				.body(file);
	}
		
	//feature adding
	@RequestMapping("/showProject")
	public String showProject(@RequestParam("studentProjectId")int id, Model theModel)
	{
		StudentDetails project = studentDetailsDAO.findByStudentId(id);
		theModel.addAttribute("project",project);
		return "evaluator/show-project";
	}
	
}
