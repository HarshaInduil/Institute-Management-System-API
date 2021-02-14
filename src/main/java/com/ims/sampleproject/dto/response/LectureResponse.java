package com.ims.sampleproject.dto.response;

import com.ims.sampleproject.dto.enumtype.Experience;
import com.ims.sampleproject.model.Lecture;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LectureResponse {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String contactNumber;
    private Date joinedDate;
    private Experience experience;
    private BigDecimal salary;
    private String lectureCode;

    public LectureResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.name = lecture.getName();
        this.address = lecture.getAddress();
        this.email = lecture.getEmail();
        this.contactNumber = lecture.getContactNumber();
        this.joinedDate = lecture.getJoinedDate();
        this.experience = lecture.getExperience();
        this.salary = lecture.getSalary();
        this.lectureCode = lecture.getLectureCode();
    }
}
