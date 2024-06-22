package practive.labs.project.controller;

import practive.labs.project.entity.Student;
import practive.labs.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService userService;

    @GetMapping
    public List<Student> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public Student addUser(@RequestBody Student student) {
        return userService.save(student);
    }
}
