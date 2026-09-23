package com.pulsefit.subscription.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pulsefit.subscription.entity.Plan;
import com.pulsefit.subscription.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return planService.createPlan(plan);
    }

    @GetMapping
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable Long id) {
        return planService.getPlanById(id);
    }

    @PutMapping("/{id}")
    public Plan updatePlan(
            @PathVariable Long id,
            @RequestBody Plan plan) {

        return planService.updatePlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public String deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return "Plan deleted successfully";
    }
}