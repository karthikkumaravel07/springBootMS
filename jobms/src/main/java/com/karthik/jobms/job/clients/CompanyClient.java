package com.karthik.jobms.job.clients;

import com.karthik.jobms.job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANYMS")
public interface CompanyClient {

    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable Long id);
}
