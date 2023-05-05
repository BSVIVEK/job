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

    /**
     * Create new job, done only by admin credentials.
     * @return Job
     */
    @PostMapping(value = "/createJob")
    @PreAuthorize("hasRole('ADMIN')")
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    /**
     * Apply new job.
     * @return AppData
     */
    @PostMapping(value = "/applyJob")
    public AppData applyJobs(
            @RequestParam(value = "candidId") Integer candidId,
            @RequestParam(value = "jobId") Integer jobId) {
        return jobService.applyJob(candidId, jobId);
    }

    /**
     * Get all jobs.
     * @return List of Job
     */
    @GetMapping
    public List<Job> getJobs() {
        return jobService.getJobs();
    }

    /**
     * Get values of AppData table.
     * @return List of AppData
     */
    @GetMapping(value = "/getAppData")
    public List<AppData> getAppData() {
        return jobService.getAppData();
    }

    /**
     * Get all the jobs applied by single candidate.
     * @return List of Job
     */
    @GetMapping(value = "/getAllJobsByCandidId/{candidId}")
    public List<Job> getAllJobsAppliedByCandid(@PathVariable(value = "candidId") Integer candidId) {
        return jobService.getAllJobsAppliedByCandid(candidId);
    }

    /**
     * Get all the candidates who applied for a particular job.
     * @return List of Candidates
     */
    @GetMapping(value = "/getAllCandidatesByJobId/{jobId}")
    public List<Candid> getAllCandidatesByJobId(@PathVariable(value = "jobId") Integer jobId) {
        return jobService.getAllCandidatesByJobId(jobId);
    }

    /**
     * Get all the relevant jobs by title.
     * @return List of Jobs.
     */
    @GetMapping(value = "/getAllJobsContainingTitle")
    public List<Job> getAllJobsContainingTitle(@RequestParam(value = "relevantJobs") String relevantJobs) {
        return jobService.getAllJobsContainingTitle(relevantJobs);
    }

    /**
     * Delete existing job, done only by admin credentials.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);

    }

}
