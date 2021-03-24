package com.ims.sampleproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course extends BaseEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    Set<Topic> topics;

    @Column(name = "name")
    private String name;

    @Column(name = "course_fee")
    private BigDecimal courseFee;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private int duration;
}
