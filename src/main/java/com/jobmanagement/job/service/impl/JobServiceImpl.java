package com.jobmanagement.job.service.impl;

import com.jobmanagement.job.entity.AppData;
import com.jobmanagement.job.entity.Candid;
import com.jobmanagement.job.entity.Job;
import com.jobmanagement.job.repository.AppDataRepository;
import com.jobmanagement.job.repository.CandidRepository;
import com.jobmanagement.job.repository.JobRepository;
import com.jobmanagement.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

/**
 * Implemented the Job Service interface and handled.
 */
@Service
public class JobServiceImpl implements JobService {


    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CandidRepository candidRepository;

    @Autowired
    private AppDataRepository appDataRepository;

    @Override
    public Job createJob(Job job) {

        return jobRepository.save(job);
    }

    @Override
    public AppData applyJob(Integer candidId, Integer jobId) {
        validateCandidIdAndJobId(candidId, jobId);

        if (appDataRepository.existsByCandidAndJobId(candidId, jobId)) {
            throw new IllegalArgumentException("The value is already in the list.");
        }

     return appDataRepository.save(new AppData(candidId, jobId));
    }

    private void validateCandidIdAndJobId(Integer candidId, Integer jobId) {
        if (candidRepository.findCandidByCandidId(candidId).isEmpty() || jobRepository.findJobByJobId(jobId).isEmpty()) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Job> getJobs() {
        return (List<Job>) jobRepository.findAll();
    }

    @Override
    public List<AppData> getAppData() {
        return (List<AppData>) appDataRepository.findAll();
    }

    @Override
    public List<Job> getAllJobsAppliedByCandid(Integer candidId) {
        List<Integer> jobIdsForCandid = appDataRepository.findJobIdsByCandidId(candidId);
        return jobRepository.findJobsByJobIds(jobIdsForCandid);
    }

    @Override
    public List<Candid> getAllCandidatesByJobId(Integer jobId) {
        List<Integer> candidIdsForJob = appDataRepository.findCandidatesByJobId(jobId);
        return candidRepository.findCandidsByCandidIds(candidIdsForJob);
    }

    @Override
    public List<Job> getAllJobsContainingTitle(String relevantJobs) {
        return jobRepository.findJobsByJobTitleContains(relevantJobs);
    }

    @Override
    public void deleteJob(Integer jobId) {
        jobRepository.delete(jobRepository.getJobByJobId(jobId));
    }


}
