package com.ims.sampleproject.model;

import com.ims.sampleproject.dto.enumtype.Experience;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
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

    public Lecture(String name, String address, String email, String contactNumber, Date joinedDate, Experience experience, BigDecimal salary, String lectureCode) {
        super(name, address, email, contactNumber, joinedDate, experience, salary);
        this.topics = null;
        this.lectureCode = lectureCode;
    }
}
