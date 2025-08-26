package com.example.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

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
    @Builder.Default
    private List<Booking> bookings = new ArrayList<>();
}
