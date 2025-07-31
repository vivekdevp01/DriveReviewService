package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {

   Optional <Driver> findByIdAndLicenseNumber(Long id, String LicenseNumber);

//   raw mysql query errir us thrown in run time
   @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id=:id AND license_number=:license")
   Optional<Driver> rawfindByIDAndLicenseNumber(long id, String license);

   @Query("SELECT d from Driver as d where d.id=:id AND d.licenseNumber=:license")
   Optional<Driver> rawFindByIdAndLicense(long id,String license);
}
