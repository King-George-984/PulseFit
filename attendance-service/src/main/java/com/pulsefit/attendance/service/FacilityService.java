package com.pulsefit.attendance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pulsefit.attendance.entity.Facility;
import com.pulsefit.attendance.repository.FacilityRepository;

@Service
public class FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public Facility createFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    public Facility getFacilityById(Long id) {
        return facilityRepository.findById(id).orElse(null);
    }

    public Facility updateFacility(Long id, Facility facility) {

        Facility existing = facilityRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(facility.getName());
            existing.setLocation(facility.getLocation());
            existing.setAddress(facility.getAddress());
            existing.setStatus(facility.getStatus());

            return facilityRepository.save(existing);
        }

        return null;
    }

    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }
}