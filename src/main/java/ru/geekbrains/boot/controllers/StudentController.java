package ru.geekbrains.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.boot.services.StudentService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping // GET http://localhost:8189/app/students
    public String showAll(Model model,
                          @RequestParam(required = false, name = "min_score") Integer minScore,
                          @RequestParam(required = false, name = "max_score") Integer maxScore
    ) {
        model.addAttribute("students", studentService.findAll(minScore, maxScore));
        return "students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id, HttpServletResponse response) {
        studentService.deleteBydId(id);
        return "redirect:/students"; // [http://localhost:8189/app]/students
    }
}
