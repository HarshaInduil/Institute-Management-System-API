package com.ims.sampleproject.dto.response;

import com.ims.sampleproject.model.Topic;
import lombok.Data;

@Data
public class TopicResponse {
    private Long id;
    private String name;
    private int learningHours;
    private double gpaValue;
    private String description;

    public TopicResponse(Topic topic) {
        this.id = topic.getId();
        this.name = topic.getName();
        this.learningHours = topic.getLearningHours();
        this.gpaValue = topic.getGpaValue();
        this.description = topic.getDescription();
    }
}
