package com.ims.sampleproject.model;

import com.ims.sampleproject.dto.enumtype.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructor")
public class Instructor extends AcademicStaff {

    @Column(name = "insturctor_code")
    private String insturctorCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;

    public Instructor(String name, String address, String email, String contactNumber, Date joinedDate, Experience experience, BigDecimal salary, String instructorCode) {
        super(name, address, email, contactNumber, joinedDate, experience, salary);
        this.classRoom = null;
        this.insturctorCode = instructorCode;
    }
}
