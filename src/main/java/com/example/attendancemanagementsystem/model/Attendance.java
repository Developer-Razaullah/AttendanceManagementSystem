package com.example.attendancemanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    private String name;
    @Column(name = "roll_number")
    @NotNull(message = "Roll Number cannot be null")
    private long rollNumber;
    @Column(name = "present")
    private boolean present;
}
