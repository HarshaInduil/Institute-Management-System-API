package com.ims.sampleproject.dto.request;

import com.ims.sampleproject.model.Student;
import lombok.Data;

import java.util.Date;

@Data
public class StudentRequest {
    private String fullName;
    private int age;
    private Date dateOfBirth;
    private String address;
    private Date joinedDate;
    private String contactNumber;
    private String email;

    public Student getStudentEntity() {
        return new Student(
                this.fullName,
                this.age,
                this.dateOfBirth,
                this.address,
                this.joinedDate,
                this.contactNumber,
                this.email,
                null
        );
    }
}
