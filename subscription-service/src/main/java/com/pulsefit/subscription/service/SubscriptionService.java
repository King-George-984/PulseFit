package com.pulsefit.subscription.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pulsefit.subscription.entity.Subscription;
import com.pulsefit.subscription.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    public List<Subscription> getSubscriptionsByMember(Long memberId) {
        return subscriptionRepository.findByMemberId(memberId);
    }

    public Subscription updateSubscription(
            Long id, Subscription subscription) {

        Subscription existing =
                subscriptionRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setMemberId(subscription.getMemberId());
            existing.setPlanId(subscription.getPlanId());
            existing.setStartDate(subscription.getStartDate());
            existing.setEndDate(subscription.getEndDate());
            existing.setStatus(subscription.getStatus());

            return subscriptionRepository.save(existing);
        }

        return null;
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}