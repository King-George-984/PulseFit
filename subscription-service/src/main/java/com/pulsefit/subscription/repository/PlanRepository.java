package com.pulsefit.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulsefit.subscription.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}