package com.jobmanagement.job.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Maintaining this AppData as third table to handle applied jobs and candidates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "AppData")
public class AppData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Integer app_id;

    @Column(name = "candid_id")
    private Integer candid_id;

    @Column(name = "job_id")
    private Integer job_id;

    public AppData(Integer candid_id, Integer job_id) {
        this.candid_id = candid_id;
        this.job_id = job_id;
    }
}
