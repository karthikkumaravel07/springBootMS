package com.karthik.jobms.job.mapper;

import com.karthik.jobms.job.Job;
import com.karthik.jobms.job.dto.JobDTO;
import com.karthik.jobms.job.external.Company;
import com.karthik.jobms.job.external.Review;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDto(Job job, Company company, List<Review> reviews) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);
        return jobDTO;
    }
}
