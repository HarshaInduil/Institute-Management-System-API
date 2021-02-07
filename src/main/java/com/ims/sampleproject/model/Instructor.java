package com.ims.sampleproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
