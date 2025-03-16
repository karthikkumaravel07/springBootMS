package com.karthik.companyms.company.messaging;

import com.karthik.companyms.company.CompanyService;
import com.karthik.companyms.company.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {

    private final CompanyService companyService;

    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage){
        companyService.updateCompanyRating(reviewMessage);
    }

}
