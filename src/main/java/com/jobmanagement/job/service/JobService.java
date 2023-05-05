package com.jobmanagement.job.service;

import com.jobmanagement.job.entity.AppData;
import com.jobmanagement.job.entity.Candid;
import com.jobmanagement.job.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {
    Job createJob(Job job);
    AppData applyJob(Integer candidId, Integer jobId);

    List<Job> getJobs();

    List<AppData> getAppData();

    List<Job> getAllJobsAppliedByCandid(Integer candidId);

    List<Candid> getAllCandidatesByJobId(Integer jobId);

    List<Job> getAllJobsContainingTitle(String relevantJobs);

    void deleteJob(Integer jobId);

}
