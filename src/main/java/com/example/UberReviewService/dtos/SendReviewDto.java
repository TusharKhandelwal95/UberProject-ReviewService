package com.example.UberReviewService.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendReviewDto {
    private String content;
    private Double rating;
    private Long bookingId;



}
