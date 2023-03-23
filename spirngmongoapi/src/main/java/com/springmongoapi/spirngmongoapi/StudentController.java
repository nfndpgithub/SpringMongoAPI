package com.springmongoapi.spirngmongoapi;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/show")
    public List<StudentDTO> fetchAllStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping
    public boolean insertStudent (@RequestBody Student student){

        return  studentService.insetStudent(student);
    }
}
