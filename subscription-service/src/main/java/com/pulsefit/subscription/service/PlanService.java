package com.pulsefit.subscription.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pulsefit.subscription.entity.Plan;
import com.pulsefit.subscription.repository.PlanRepository;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Plan getPlanById(Long id) {
        return planRepository.findById(id).orElse(null);
    }

    public Plan updatePlan(Long id, Plan plan) {

        Plan existing = planRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(plan.getName());
            existing.setDurationMonths(plan.getDurationMonths());
            existing.setPrice(plan.getPrice());
            existing.setDescription(plan.getDescription());

            return planRepository.save(existing);
        }

        return null;
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}