package com.karthik.companyms.company;

import com.karthik.companyms.company.dto.ReviewMessage;

import java.util.List;


public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);

    public void updateCompanyRating(ReviewMessage reviewMessage);
}
