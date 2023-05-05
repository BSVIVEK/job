package com.jobmanagement.job.web.rest.controller;

import com.jobmanagement.job.entity.Candid;
import com.jobmanagement.job.service.CandidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/candid"})
public class CandidProfileController {

    @Autowired
    private CandidService candidService;

    @PostMapping
    public Candid createCandid(@RequestBody Candid candid) {
        return candidService.createCandid(candid);
    }

    @GetMapping
    public List<Candid> getCandids() {
        return candidService.getCandids();
    }
}
