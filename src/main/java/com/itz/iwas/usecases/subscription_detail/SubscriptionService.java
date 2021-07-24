package com.itz.iwas.usecases.subscription_detail;

import com.itz.iwas.usecases.subscription_detail.pojo.SubscriptionPojo;
import org.springframework.beans.factory.annotation.Autowired;
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
}
