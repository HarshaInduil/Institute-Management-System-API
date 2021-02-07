package com.ims.sampleproject.dto.response;

import com.ims.sampleproject.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String fullName;
    private int age;
    private Date dateOfBirth;
    private String address;
    private Date joinedDate;
    private String contactNumber;
    private String email;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.fullName = student.getFullName();
        this.age = student.getAge();
        this.dateOfBirth = student.getDateOfBirth();
        this.address = student.getAddress();
        this.joinedDate = student.getJoinedDate();
        this.contactNumber = student.getContactNumber();
        this.email = student.getEmail();
    }
}
