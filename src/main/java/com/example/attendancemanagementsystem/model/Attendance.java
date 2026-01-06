package com.example.attendancemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    @Column(name = "name")
    @NotBlank(message = "Name cannot be null")
    private String name;
    @Column(name = "roll_number")
    @NotBlank(message = "Roll Number cannot be null")
    private long rollNumber;
    @Column(name = "present")
    @Schema(defaultValue = "false", description = "Status of the present")
    private boolean present;
}
