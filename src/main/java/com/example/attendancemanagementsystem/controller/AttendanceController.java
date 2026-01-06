package com.example.attendancemanagementsystem.controller;

import com.example.attendancemanagementsystem.model.Attendance;
import com.example.attendancemanagementsystem.service.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AttendanceController {

    AttendanceService attendanceService;

    @Operation(summary = "Gets Attendance Details", description = "Attendance must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Attendance.class)) }),
            @ApiResponse(responseCode = "404", description = "Attendance not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorResponse.class)) }) })
    @GetMapping("getAttendance")
    public ResponseEntity<List<Attendance>> attendance() {
        return ResponseEntity.ok(attendanceService.attendance());
    }

    @Operation(summary = "Gets Attendance Details By Id", description = "Attendance must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Attendance.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Attendance not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorResponse.class)) }) })
    @GetMapping("getAttendance/{roll_number}")
    public ResponseEntity<Optional<Attendance>> getAttendanceByRollNumber(@PathVariable("roll_number") long rollNumber) {
        return ResponseEntity.ok(attendanceService.attendance(rollNumber));
    }

    @Operation(summary = "Create Attendance", description = "Add Attendance Details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Request Object"),
            @ApiResponse(responseCode = "404", description = "Attendance not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorResponse.class)) }) })
    @PostMapping("attendance")
    public ResponseEntity<String> getAttendance(@RequestBody @Valid Attendance request) {
        return ResponseEntity.ok(attendanceService.getAttendance(request));
    }
}
