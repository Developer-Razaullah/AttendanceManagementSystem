package com.example.attendancemanagementsystem.controller;

import com.example.attendancemanagementsystem.model.Attendance;
import com.example.attendancemanagementsystem.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AttendanceController {

    AttendanceService attendanceService;

    @GetMapping("getAttendance")
    public ResponseEntity<List<Attendance>> attendance() {
        return ResponseEntity.ok(attendanceService.attendance());
    }

    @GetMapping("getAttendance/{id}")
    public ResponseEntity<Optional<Attendance>> getAttendanceByRollNumber(@PathVariable("id") long rollNumber) {
        return ResponseEntity.ok(attendanceService.attendance(rollNumber));
    }

    @PostMapping("attendance")
    public ResponseEntity<String> getAttendance(@RequestBody @Validated Attendance request) {
        return ResponseEntity.ok(attendanceService.getAttendance(request));
    }
}
