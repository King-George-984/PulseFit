package com.pulsefit.attendance.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pulsefit.attendance.entity.Attendance;
import com.pulsefit.attendance.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/check-in")
    public Attendance checkIn(@RequestBody Attendance attendance) {
        return attendanceService.checkIn(attendance);
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @GetMapping("/member/{memberId}")
    public List<Attendance> getAttendanceByMember(@PathVariable Long memberId) {
        return attendanceService.getAttendanceByMember(memberId);
    }

    @GetMapping("/facility/{facilityId}")
    public List<Attendance> getAttendanceByFacility(@PathVariable Long facilityId) {
        return attendanceService.getAttendanceByFacility(facilityId);
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(
            @PathVariable Long id,
            @RequestBody Attendance attendance) {

        return attendanceService.updateAttendance(id, attendance);
    }

    @DeleteMapping("/{id}")
    public String deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return "Attendance deleted successfully";
    }
}