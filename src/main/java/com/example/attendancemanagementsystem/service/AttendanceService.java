package com.example.attendancemanagementsystem.service;

import com.example.attendancemanagementsystem.model.Attendance;
import com.example.attendancemanagementsystem.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttendanceService {

    AttendanceRepository attendanceRepository;

    public List<Attendance> attendance() {
        log.info("attendance method");
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> attendance(long rollNumber) {
        log.info("attendance method With roll Number: {}", rollNumber);
        return attendanceRepository.findById(rollNumber);
    }

    public String getAttendance(Attendance attendance) {
        log.info("getAttendance Method");
        if (ObjectUtils.isEmpty(attendance)) {
            return "FAILED";
        }
        attendanceRepository.save(attendance);
        return "SUCCESS";
    }
}
