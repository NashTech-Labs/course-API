package io.knoldus.student;

import io.knoldus.course.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);
}
