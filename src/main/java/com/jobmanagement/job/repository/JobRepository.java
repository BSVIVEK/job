package com.jobmanagement.job.repository;

import com.jobmanagement.job.entity.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Job Repository.
 */
public interface JobRepository extends CrudRepository<Job, Long> {
    Optional<Job> findJobByJobId(Integer jobId);

    Job getJobByJobId(Integer jobId);

    @Query("SELECT j FROM Job j WHERE j.jobId IN :jobIds")
    List<Job> findJobsByJobIds(@Param("jobIds") List<Integer> jobIds);

    List<Job> findJobsByJobTitleContains(String relevantText);

}
