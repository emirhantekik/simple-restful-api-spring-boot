package com.example.restservice.Controller;

import com.example.restservice.Entity.Student;
import com.example.restservice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apii/v1")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/Students")
    public ResponseEntity<List<Student>>getAllStudent(){
        return ResponseEntity.ok().body(studentService.getStudentList());
    }

    @GetMapping("/Student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return ResponseEntity.ok().body(this.studentService.getStudentId(id));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return ResponseEntity.ok(this.studentService.createStudent(student));
    }

    @PostMapping("/addStudents")
    public ResponseEntity<List<Student>> addStudents(@RequestBody Student student){
        return ResponseEntity.ok(this.studentService.getStudentList());
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(this.studentService.updateStudentById(student));
    }

    @DeleteMapping("/deleteStudent/{id}")
    public HttpStatus deleteStudent(@PathVariable int id){
        this.studentService.deleteByStudentId(id);
        return HttpStatus.OK;
    }



}
