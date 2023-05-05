package com.jobmanagement.job.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Candidate Table.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Candidate")
public class Candid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer candidId;

    @Column(name = "name")
    private String candidFullName;

    @Column(name = "email")
    private String emailId;

    @Column(name = "phone")
    private String mobile;

    @Column(name = "resume")
    private String resumeHeadLine;

}
