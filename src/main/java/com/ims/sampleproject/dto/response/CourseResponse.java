package com.ims.sampleproject.dto.response;

import com.ims.sampleproject.model.Course;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseResponse {
    private Long id;
    private String name;
    private BigDecimal courseFee;
    private String description;
    private int duration;

    public CourseResponse(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.courseFee = course.getCourseFee();
        this.description = course.getDescription();
        this.duration = course.getDuration();
    }
}
