package com.karthik.jobms.job;

import com.karthik.jobms.job.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {


    private JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job created..!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id){
        JobDTO jobDTO = jobService.getJobById(id);
        if(jobDTO != null) return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted) return new ResponseEntity<>("job deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("job not found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated) return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
