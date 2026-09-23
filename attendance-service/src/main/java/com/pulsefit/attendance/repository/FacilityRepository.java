package com.pulsefit.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pulsefit.attendance.entity.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
}