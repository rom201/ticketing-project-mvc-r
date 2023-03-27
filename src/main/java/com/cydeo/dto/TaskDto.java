package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDto {

    private Long id;
    private  String project;
    private  String assignedEmployee;
    private  String taskSubject;
    private  String taskDetail;

    private Status taskStatus;
    private LocalDate assignedDate;



}
