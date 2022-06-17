package io.knoldus.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public ResponseEntity<String> addStudent(Student student) {
        if(studentRepository.findByEmail(student.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email ID already exist (CODE 400)\n");
        } else {
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("New Student Added (CODE 201)\n");
        }
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public ResponseEntity<String> getStudent(int id) {
        if (studentRepository.findById(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.CREATED)
          .body("Student Name : " + studentRepository.findById(id).get().getFirstName());
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Doesnt found (CODE 400)\n");
    }
}
