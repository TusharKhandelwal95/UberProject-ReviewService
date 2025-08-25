package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // cascade will save the review object when booking object is saved and delete the review object when booking object is deleted
    private Review review; // Composition -- has a relationship

    @Enumerated(value=EnumType.STRING)
    private BookingSatus bookingStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne
    private Driver driver; // many bookings can be associated with one driver

    @ManyToOne
    private Passenger passenger; // many bookings can be associated with one passenger
}
