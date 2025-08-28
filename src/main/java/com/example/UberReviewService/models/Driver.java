package com.example.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel{

    private String name;

    private String licenseNumber;

    //1:n Driver : Bookings
    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY) // mappedBy should be the name of the attribute in the Booking class that owns the relationship
    // fetchType LAZY means that the bookings will be loaded only when they are accessed for the first time
    // EAGER means that the bookings will be loaded immediately with the driver
    @Fetch(FetchMode.SUBSELECT) // to avoid n+1 select problem
    private List<Booking> bookings;
}
