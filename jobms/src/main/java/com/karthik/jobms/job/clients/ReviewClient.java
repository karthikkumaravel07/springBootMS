package com.karthik.jobms.job.clients;

import com.karthik.jobms.job.external.Company;
import com.karthik.jobms.job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEWMS")
public interface ReviewClient {

    @GetMapping("/reviews")
    List<Review> getReviews(@RequestParam("companyId") Long companyId);
}
