package com.ims.sampleproject.dto.request;

import com.ims.sampleproject.model.CourseRegistration;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CourseRegistrationRequest {
    private Long studentId;
    private Long batchId;
    private Date registeredDate;
    private BigDecimal courseFee;
    private String remark;

    public CourseRegistration getCourseRegistrationObject() {
        return new CourseRegistration(
                null,
                null,
                this.registeredDate,
                this.courseFee,
                this.remark
        );
    }
}
