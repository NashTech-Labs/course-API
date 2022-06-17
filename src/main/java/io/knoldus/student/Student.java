package io.knoldus.student;

import io.knoldus.course.Course;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
    @Id
    private int rollNumber;
    private String firstName;
    private String lastName;
    private Gender GENDER;
    private Address address;
    @Indexed(unique = true)
    private String email;

    @DBRef
    private Course course;


    public Student() {
    }

    public Student(int rollNumber, String firstName, String lastName, Gender GENDER, Address address, String email, String courseId) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.GENDER = GENDER;
        this.address = new Address("","","");
        this.email = email;
        this.course = new Course(courseId, "", "");
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGENDER() {
        return GENDER;
    }

    public void setGENDER(Gender GENDER) {
        this.GENDER = GENDER;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
