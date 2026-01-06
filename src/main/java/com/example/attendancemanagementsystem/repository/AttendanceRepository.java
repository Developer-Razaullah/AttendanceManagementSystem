package com.example.attendancemanagementsystem.repository;

import com.example.attendancemanagementsystem.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByRollNumber(Long rollNumber);

}

