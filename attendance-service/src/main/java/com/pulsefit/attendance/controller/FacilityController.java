package com.pulsefit.attendance.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pulsefit.attendance.entity.Facility;
import com.pulsefit.attendance.service.FacilityService;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping
    public Facility createFacility(@RequestBody Facility facility) {
        return facilityService.createFacility(facility);
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable Long id) {
        return facilityService.getFacilityById(id);
    }

    @PutMapping("/{id}")
    public Facility updateFacility(
            @PathVariable Long id,
            @RequestBody Facility facility) {

        return facilityService.updateFacility(id, facility);
    }

    @DeleteMapping("/{id}")
    public String deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
        return "Facility deleted successfully";
    }
}