package com.ims.sampleproject.dto.request;

import com.ims.sampleproject.dto.enumtype.Experience;
import com.ims.sampleproject.model.Instructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InstructorRequest {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String contactNumber;
    private Date joinedDate;
    private Experience experience;
    private BigDecimal salary;
    private String instructorCode;

    public Instructor getInstructorObject() {
        return new Instructor(
                this.name,
                this.address,
                this.email,
                this.contactNumber,
                this.joinedDate,
                this.experience,
                this.salary,
                this.instructorCode
        );
    }
}
