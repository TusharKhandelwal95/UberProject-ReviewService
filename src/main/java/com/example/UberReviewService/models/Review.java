package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="bookingreview")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String content;

    private Double rating;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)  // this will tell spring about format of date object to be stored (ie date + time)
    @CreatedDate // this will tell spring to auto populate this field with current date when record is created
    private Date createdAt;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate // this will tell spring to auto populate this field with current date when record is updated
    private Date updatedAt;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
