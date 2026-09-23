package com.pulsefit.subscription.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pulsefit.subscription.entity.Subscription;
import com.pulsefit.subscription.service.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(
            SubscriptionService subscriptionService) {

        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public Subscription createSubscription(
            @RequestBody Subscription subscription) {

        return subscriptionService.createSubscription(subscription);
    }

    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    public Subscription getSubscriptionById(
            @PathVariable Long id) {

        return subscriptionService.getSubscriptionById(id);
    }

    @GetMapping("/member/{memberId}")
    public List<Subscription> getSubscriptionsByMember(
            @PathVariable Long memberId) {

        return subscriptionService
                .getSubscriptionsByMember(memberId);
    }

    @PutMapping("/{id}")
    public Subscription updateSubscription(
            @PathVariable Long id,
            @RequestBody Subscription subscription) {

        return subscriptionService
                .updateSubscription(id, subscription);
    }

    @DeleteMapping("/{id}")
    public String deleteSubscription(
            @PathVariable Long id) {

        subscriptionService.deleteSubscription(id);

        return "Subscription deleted successfully";
    }
}