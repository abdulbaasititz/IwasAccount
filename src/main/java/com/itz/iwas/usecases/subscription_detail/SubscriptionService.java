package com.itz.iwas.usecases.subscription_detail;

import com.itz.iwas.usecases.subscription_detail.pojo.SubscriptionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;

//    public List<SubscriptionDum> getAllSubscription(){
//        return subscriptionRepository.findAll();
//    }

    public List<SubscriptionPojo> getAllSubscription() {
        return subscriptionRepository.getAllSubscription();
    }

    public Page<SubscriptionPojo> getSubscription(int pn, int ps) {
        Pageable pg = PageRequest.of(pn, ps);
        return subscriptionRepository.getSubscription(pg);
    }

//    public List<SubscriptionPojo> getSubscriptionByDate(){
//        return subscriptionRepository.getSubscriptionByDate();
//    }

    public String getTotalAmount() {
        return subscriptionRepository.totalAmount();
    }
}
