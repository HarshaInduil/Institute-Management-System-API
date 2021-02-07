package com.ims.sampleproject.model;

import com.ims.sampleproject.dto.enumtype.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private Status status;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    @Version
    @Column(name = "version")
    private Long version;
}
