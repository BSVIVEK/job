package com.jobmanagement.job.repository;

import com.jobmanagement.job.entity.Candid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Candidate Repository.
 */
public interface CandidRepository extends CrudRepository<Candid, Long> {
    Optional<Candid> findCandidByCandidId(Integer id);

    @Query("SELECT c from Candid c where c.candidId IN :candidIds")
    List<Candid> findCandidsByCandidIds(@Param("candidIds") List<Integer> candidIds);


}
