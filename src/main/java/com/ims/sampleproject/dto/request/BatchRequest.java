package com.ims.sampleproject.dto.request;

import com.ims.sampleproject.model.Batch;
import lombok.Data;

import java.util.Date;

@Data
public class BatchRequest {
    private Long id;
    private String name;
    private int maximumStudentCount;
    private Date startDate;
    private String description;

    public Batch getBatchObject() {
        return new Batch(
                this.name,
                this.maximumStudentCount,
                this.startDate,
                this.description,
                null,
                null
        );
    }
}
