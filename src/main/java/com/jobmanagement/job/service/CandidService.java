package com.jobmanagement.job.service;

import com.jobmanagement.job.entity.Candid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CandidService {
    Candid createCandid(Candid candid);

    List<Candid> getCandids();
}
