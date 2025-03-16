package com.karthik.companyms.company.impl;

import com.karthik.companyms.company.Company;
import com.karthik.companyms.company.CompanyRepository;
import com.karthik.companyms.company.CompanyService;
import com.karthik.companyms.company.clients.ReviewClient;
import com.karthik.companyms.company.dto.ReviewMessage;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private ReviewClient reviewClient;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClient reviewClient){
        this.companyRepository = companyRepository;
        this.reviewClient = reviewClient;
    }
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company1 = companyOptional.get();
            company1.setDescription(company.getDescription());
            company1.setName(company.getName());
            companyRepository.save(company1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        Company company = companyRepository.findById(reviewMessage.getCompanyId())
                .orElseThrow(()-> new NotFoundException("Company not found"+ reviewMessage.getCompanyId()));
        double averageRating = reviewClient.getAverageRatingForCompany(reviewMessage.getCompanyId());
        company.setRating(averageRating);
        companyRepository.save(company);
    }

}
