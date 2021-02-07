package com.ims.sampleproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "batches")
public class Batch extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "max_student_count")
    private int maximumStudentCount;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "batch")
    private Set<CourseRegistration> courseRegistrationSet;
}
