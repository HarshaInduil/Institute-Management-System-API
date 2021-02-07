package com.ims.sampleproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topics")
public class Topic extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "learning_hours")
    private int learningHours;

    @Column(name = "gpa_value")
    private double gpaValue;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "topics")
    private Set<Lecture> lectures;
}
