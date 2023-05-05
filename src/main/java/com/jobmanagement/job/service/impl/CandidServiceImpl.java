package com.jobmanagement.job.service.impl;

import com.jobmanagement.job.entity.Candid;
import com.jobmanagement.job.repository.CandidRepository;
import com.jobmanagement.job.service.CandidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidServiceImpl implements CandidService {

    @Autowired
    private CandidRepository candidRepository;

    @Override
    public Candid createCandid(Candid candid) {
        return candidRepository.save(candid);
    }

    @Override
    public List<Candid> getCandids() {
        return (List<Candid>) candidRepository.findAll();
    }
}
