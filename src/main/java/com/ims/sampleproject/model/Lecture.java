package com.ims.sampleproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lecture")
public class Lecture extends AcademicStaff {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "lecture_subject",
            joinColumns = @JoinColumn(name = "lecture_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    Set<Topic> topics;
    @Column(name = "lecture_code")
    private String lectureCode;
}
