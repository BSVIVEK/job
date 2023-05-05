package com.jobmanagement.job.repository;

import com.jobmanagement.job.entity.AppData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppDataRepository extends CrudRepository<AppData, Long> {

    @Query("SELECT COUNT(a) > 0 FROM AppData a WHERE a.candid_id = :candidId AND a.job_id = :jobId")
    boolean existsByCandidAndJobId(@Param("candidId") Integer candidId, @Param("jobId") Integer jobId);

    @Query("SELECT a.job_id FROM AppData a WHERE a.candid_id = :candidId")
    List<Integer> findJobIdsByCandidId(@Param("candidId") Integer candidId);

    @Query("SELECT a.candid_id FROM AppData a WHERE a.job_id = :jobId")
    List<Integer> findCandidatesByJobId(@Param("jobId") Integer jobId);

}
