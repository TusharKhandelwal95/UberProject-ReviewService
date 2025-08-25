package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class) // this will tell spring to auto populate createdAt and updatedAt fields
@MappedSuperclass // this will tell spring that this class is not a table but its fields should be inherited by child classes
@Getter
@Setter
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)  // this will tell spring about format of date object to be stored (ie date + time)
    @CreatedDate // this will tell spring to auto populate this field with current date when record is created
    protected Date createdAt;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate // this will tell spring to auto populate this field with current date when record is updated
    protected Date updatedAt;
}
