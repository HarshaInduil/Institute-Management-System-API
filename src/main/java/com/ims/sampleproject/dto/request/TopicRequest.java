package com.ims.sampleproject.dto.request;

import com.ims.sampleproject.model.Topic;
import lombok.Data;

@Data
public class TopicRequest {
    private Long id;
    private String name;
    private int learningHours;
    private double gpaValue;
    private String description;

    public Topic getTopicEntity() {
        return new Topic(
                this.name,
                this.learningHours,
                this.gpaValue,
                this.description,
                null
        );
    }
}