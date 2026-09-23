package com.pulsefit.attendance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pulsefit.attendance.entity.Attendance;
import com.pulsefit.attendance.repository.AttendanceRepository;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Attendance checkIn(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public List<Attendance> getAttendanceByMember(Long memberId) {
        return attendanceRepository.findByMemberId(memberId);
    }

    public List<Attendance> getAttendanceByFacility(Long facilityId) {
        return attendanceRepository.findByFacilityId(facilityId);
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {

        Attendance existing = attendanceRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setMemberId(attendance.getMemberId());
            existing.setFacilityId(attendance.getFacilityId());
            existing.setCheckInTime(attendance.getCheckInTime());
            existing.setCheckOutTime(attendance.getCheckOutTime());
            existing.setStatus(attendance.getStatus());

            return attendanceRepository.save(existing);
        }

        return null;
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}