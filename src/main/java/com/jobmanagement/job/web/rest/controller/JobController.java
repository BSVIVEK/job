package com.jobmanagement.job.web.rest.controller;

import com.jobmanagement.job.entity.AppData;
import com.jobmanagement.job.entity.Candid;
import com.jobmanagement.job.entity.Job;
import com.jobmanagement.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping(value = "/createJob")
    @PreAuthorize("hasRole('ADMIN')")
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @PostMapping(value = "/applyJob")
    public AppData applyJobs(
            @RequestParam(value = "candidId") Integer candidId,
            @RequestParam(value = "jobId") Integer jobId) {
        return jobService.applyJob(candidId, jobId);
    }

    @GetMapping
    public List<Job> getJobs() {
        return jobService.getJobs();
    }

    @GetMapping(value = "/getAppData")
    public List<AppData> getAppData() {
        return jobService.getAppData();
    }

    @GetMapping(value = "/getAllJobsByCandidId/{candidId}")
    public List<Job> getAllJobsAppliedByCandid(@PathVariable(value = "candidId") Integer candidId) {
        return jobService.getAllJobsAppliedByCandid(candidId);
    }

    @GetMapping(value = "/getAllCandidatesByJobId/{jobId}")
    public List<Candid> getAllCandidatesByJobId(@PathVariable(value = "jobId") Integer jobId) {
        return jobService.getAllCandidatesByJobId(jobId);
    }

    @GetMapping(value = "/getAllJobsContainingTitle")
    public List<Job> getAllJobsContainingTitle(@RequestParam(value = "relevantJobs") String relevantJobs) {
        return jobService.getAllJobsContainingTitle(relevantJobs);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);

    }

}
