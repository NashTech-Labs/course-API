package io.knoldus.student;

import io.knoldus.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/courses/{courseId}/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping("/courses/{courseId}/students/{id}")
    public ResponseEntity<String> getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses/{courseId}/students")
    public ResponseEntity<String> addStudent(@RequestBody Student student, @PathVariable String courseId) {
        student.setCourse(new Course(courseId, "", ""));
        return studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{courseId}/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable String courseId) {
        student.setCourse(new Course(courseId, "", ""));
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{courseId}/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

}
