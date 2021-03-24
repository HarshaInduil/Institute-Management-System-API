package com.ims.sampleproject.dto.response;

import com.ims.sampleproject.dto.enumtype.Experience;
import com.ims.sampleproject.model.Instructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InstructorResponse {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String contactNumber;
    private Date joinedDate;
    private Experience experience;
    private BigDecimal salary;
    private String instructorCode;

    public InstructorResponse(Instructor instructor) {
        this.id = instructor.getId();
        this.name = instructor.getName();
        this.address = instructor.getAddress();
        this.email = instructor.getEmail();
        this.contactNumber = instructor.getContactNumber();
        this.joinedDate = instructor.getJoinedDate();
        this.experience = instructor.getExperience();
        this.salary = instructor.getSalary();
        this.instructorCode = instructor.getInsturctorCode();
    }
}
