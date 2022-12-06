package com.universityproject.admin_controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.universityproject.admin_dao.EvaluatorDAO;
import com.universityproject.admin_dao.StudentDAO;
import com.universityproject.admin_entity.Evaluator;
import com.universityproject.admin_entity.Student;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	EvaluatorDAO evaluatorDAO;
	@Autowired
	StudentDAO studentDAO;
	
	@RequestMapping("/adminPage")
	public String addUser(Model theModel)
	{
		
		System.out.print("in controller");
		
		return "admin/admin_page";
	}
	//for testing purpose...getting html from ajax
	@RequestMapping("/forAjax")
	public String ajax()
	{
		return "admin/ajax";
	}
	
	@RequestMapping("/showStudents")
	public String showStudents(Model theModel)
	{
		List<Student>students=studentDAO.findAll();
		theModel.addAttribute("students",students);
		return "admin/show-students-list";
	}
	@RequestMapping("/showEvaluators")
	public String showEvaluators(Model theModel)
	{
		List<Evaluator>evaluators=evaluatorDAO.findAll();
		theModel.addAttribute("evaluators",evaluators);
		return "admin/show-evaluators";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(Model theModel)
	{
		List<Evaluator>evaluators=evaluatorDAO.findAll();//we can add this in session
		theModel.addAttribute("evaluators",evaluators);
        Student student=new Student();
		theModel.addAttribute("student",student);
		return  "admin/studentForm";
	}
	
	@RequestMapping("/postAddStudent")
	public String postAddStudent(@ModelAttribute("student") Student theStudent)
	{
		//if student is to be updated
		System.out.println("name:"+theStudent.getName()+"id:"+theStudent.getId());
		
		System.out.println("in post");
		String id=theStudent.getEvaluatorId();
		String name=theStudent.getName();
		Evaluator evaluator=null;
		if(id!="" && name!="")
		{
			Optional<Evaluator> theEvaluator = evaluatorDAO.findById(Integer.parseInt(id));
			if(theEvaluator.isPresent())
				evaluator=theEvaluator.get();
			theStudent.addEvaluator(evaluator);
			System.out.println(evaluator);
			
			studentDAO.save(theStudent);
		}
		return "redirect:adminPage";
	}
	
	@RequestMapping("/addEvaluator")
	public String addEvaluator(Model theModel)
	{
		Evaluator evaluator=new Evaluator();
		theModel.addAttribute("evaluator",evaluator);
		return "admin/evaluatorForm";
	}
	@RequestMapping("/postAddEvaluator")
	public String postAddEvaluator(@ModelAttribute("evaluator") Evaluator theEvaluator)
	{
		
		if(theEvaluator.getName()!="" &&theEvaluator.getId()==0)
		{System.out.println("newly added");
			evaluatorDAO.save(theEvaluator);		
		}
		else if(theEvaluator.getName()!="" ){
			evaluatorDAO.setEvalInfoById(theEvaluator.getName(),theEvaluator.getId());
			System.out.println("updated");
		}
		return "redirect:adminPage";
	}
	@RequestMapping("/updateEvaluator")
	public String updateEvaluator(@RequestParam("evaluatorId") int evaluatorId,Model theModel)
	{
		System.out.println("in update"+evaluatorId);
		Evaluator thEvaluator=null;
		
		Optional<Evaluator> evaluator=evaluatorDAO.findById(evaluatorId);
		if(evaluator.isPresent())
		{
			thEvaluator=evaluator.get();
		}
		theModel.addAttribute("evaluator", evaluator);
		return "admin/evaluatorForm";
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent(@RequestParam("studentId")int studentId,Model theModel)
	{
		System.out.println("update in student:"+studentId);
		Optional<Student> theStudent =studentDAO.findById(studentId);
		Student student=new Student();
		if(theStudent.isPresent())
		{
			student=theStudent.get();
		}
	     System.out.println(student.getEvaluator());
		student.setEvaluatorId(""+student.getEvaluator().getId());
		System.out.println("update in student:"+student.getEvaluatorId());
		theModel.addAttribute("student",student);
		List<Evaluator>evaluators=evaluatorDAO.findAll();
		theModel.addAttribute("evaluators",evaluators);
		return "admin/studentForm";
	}
	
	
}
