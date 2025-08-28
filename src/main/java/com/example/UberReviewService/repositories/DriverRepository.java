package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

//    @Query(nativeQuery = true, value = "SELECT * FROM Driver WHERE id = :id AND license_number = :license") // raw mysql query, error is thrown at runtime
//    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);
//
//    @Query("SELECT d FROM Driver d WHERE d.id = :id AND d.licenseNumber = :license") // hibernate query, error is thrown at compile time
//    Optional<Driver> hqlFindByIdAndLicenseNumber(Long id, String license);

//    @Query(nativeQuery = true, value = "SELECT * FROM Driver d WHERE d.id IN :ids")
//    List<Driver> rawFindDriversById(List<Long> ids);

    List<Driver> findByIdIn(List<Long> ids);
}
