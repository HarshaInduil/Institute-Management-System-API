package com.ims.sampleproject.dto.request;

import com.ims.sampleproject.model.Course;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseRequest {
    private Long id;
    private String name;
    private BigDecimal courseFee;
    private String description;
    private int duration;

    public Course getCourseEntity() {
        return new Course(
                null,
                this.name,
                this.courseFee,
                this.description,
                this.duration
        );
    }
}
