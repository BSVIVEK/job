package com.jobmanagement.job.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "title")
    private String jobTitle;

    @Column(name = "description")
    private String jobDescription;

    @Column(name = "location")
    private String location;

    @Column(name = "salary")
    private double salary;

    @Column(name = "status")
    private String status;

}
