package com.ims.sampleproject.dto.response;

import com.ims.sampleproject.model.Batch;
import lombok.Data;

import java.util.Date;

@Data
public class BatchResponse {
    private Long id;
    private String name;
    private int maximumStudentCount;
    private Date startDate;
    private String description;

    public BatchResponse(Batch batch) {
        this.id = batch.getId();
        this.name = batch.getName();
        this.maximumStudentCount = batch.getMaximumStudentCount();
        this.startDate = batch.getStartDate();
        this.description = batch.getDescription();
    }
}
