package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.bean.School;
import pl.coderslab.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "JavaScript", "php", "FortRun", "Logo");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Lego", "Basketball", "Bicycle", "Climbing", "Logo");
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

//    @ModelAttribute("modelAtrSchools")
//    public List<School> schools(){
//        List<School> schools = new ArrayList<>();
//        schools.add(new School( "SP im.blabla", 1));
//        schools.add(new School( "LO im.blabla", 2));
//        schools.add(new School( "PW", 3));
//        schools.add(new School( "coderslab", 4));
//        return schools;
//    }

    @GetMapping("/student")
    private String showForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentAdd";
    }

    @PostMapping("/student")
    @ResponseBody
    private String addStudent(Student student){

        return "added : "  + student.toString();
    }



}
