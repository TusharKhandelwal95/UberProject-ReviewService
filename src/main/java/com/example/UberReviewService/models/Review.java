package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="booking_review")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // this will tell spring to use single table for all child classes of Review class
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // this will create separate table for each child class long with table for Review class as well
@Inheritance(strategy = InheritanceType.JOINED) // this will create separate table for each child class containing only unique fields of child class and common fields will be stored in parent class table
public class Review extends BaseModel {

    @Column(nullable=false)
    private String content;

    private Double rating;

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
