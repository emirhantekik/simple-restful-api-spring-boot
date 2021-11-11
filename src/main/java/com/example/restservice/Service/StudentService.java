package com.example.restservice.Service;

import com.example.restservice.Entity.Student;
import com.example.restservice.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent (Student student){
        return studentRepository.save(student);
    }

    public List<Student> createList(List<Student> list){
        return studentRepository.saveAll(list);
    }

    public List<Student> getStudentList(){
        return studentRepository.findAll();
    }

    public Student getStudentId(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudentById(Student student){
        Optional<Student> studentFound = studentRepository.findById(student.getId());

        if(studentFound.isPresent()){
            Student studentUpdate = studentFound.get();
            studentUpdate.setFirstName(student.getFirstName());
            studentUpdate.setLastName(student.getLastName());
            studentUpdate.setEmail(student.getEmail());

            return studentRepository.save(student);
        }
        else return null;
    }

    public String deleteByStudentId(int id){
        studentRepository.deleteById(id);
        return "Student "+ id + "deleted";
    }

}
