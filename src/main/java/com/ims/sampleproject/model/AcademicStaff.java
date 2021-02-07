package com.ims.sampleproject.model;

import com.ims.sampleproject.dto.enumtype.Experience;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
@Data
public class AcademicStaff extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "joined_date")
    private Date joinedDate;

    @Column(name = "experience_level")
    private Experience experience;

    @Column(name = "salary")
    private BigDecimal salary;
}
