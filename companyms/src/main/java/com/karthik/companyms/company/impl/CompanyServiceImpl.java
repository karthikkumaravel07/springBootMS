package com.karthik.companyms.company.impl;

import com.karthik.companyms.company.Company;
import com.karthik.companyms.company.CompanyRepository;
import com.karthik.companyms.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
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

}
