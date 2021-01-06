package com.semarslan.webFlux.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document
public class Exam {

    @Id
    private String id;

    private String teacherName;

    private String classRoom;

    private String department;

    private Date startDate;
}
