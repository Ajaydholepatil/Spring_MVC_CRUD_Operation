/**
 * Created By Krishna Shinde
 * Date : 13-05-2023
 * Time : 21:55
 * Project: SpringMvcCRUDOperatn
 **/

package com.mvccrud.controllers;

import com.mvccrud.dao.StudentDao;
import com.mvccrud.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class StudentController {
@Autowired
    StudentDao sdao;

@RequestMapping("/student")
    public ModelAndView StudentView(){
    int rno=sdao.nextRollNo();
    Student student=new Student(rno,"","",0);
    ModelAndView mav=new ModelAndView("student","command",student);
    List<Student> lst=sdao.getAllStudents();
    mav.addObject("student",lst);
    return mav;
}

@RequestMapping(value="/student",method = RequestMethod.POST )
    public ModelAndView addStudent(@ModelAttribute("student")Student student){
    sdao.addStudent(student);
    int  rno=sdao.nextRollNo();
    Student student1=new Student(rno,"","",0);
    ModelAndView mav=new ModelAndView("student","command",student1);
    List<Student> lst=sdao.getAllStudents();
    mav.addObject("student",lst);
    return mav;
}

@RequestMapping(value="edit/{id}",method = RequestMethod.GET)
    public ModelAndView EditStudent(@PathVariable("id")int rno){
    Student student=sdao.getStudentByRno(rno);
    ModelAndView mav=new ModelAndView("edit","command",student);
   List<Student>lst=sdao.getAllStudents();
   mav.addObject("student",lst);
    return mav;
}

@RequestMapping(value="edit",method = RequestMethod.POST)
    public RedirectView EditView(@ModelAttribute("e")Student student){
    sdao.updateStudent(student);
    RedirectView r=new RedirectView();
    r.setUrl("/CrudOperation/student");
    return r;
}

@RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public RedirectView DeleteStudent(@PathVariable("id")int rno){
    sdao.deleteStudent(rno);
    RedirectView r=new RedirectView();
    r.setUrl("CrudOperation/student");
    return r;
}
}


