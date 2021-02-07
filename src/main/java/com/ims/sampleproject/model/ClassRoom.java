package com.ims.sampleproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class_rooms")
public class ClassRoom extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_seats")
    private int numberOfSeat;

    @Column(name = "description")
    private String description;
}
