package com.itz.iwas.usecases.subscription_detail;

import com.itz.iwas.usecases.subscription_detail.pojo.SubscriptionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("${spring.base.path}" + "/v1")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("/get/all-subscription")
    public ResponseEntity<?> getAllSubscription(HttpServletRequest request) {
        List<SubscriptionPojo> getAllSubscription = subscriptionService.getAllSubscription();
        return new ResponseEntity<>(getAllSubscription, HttpStatus.OK);
    }
}
