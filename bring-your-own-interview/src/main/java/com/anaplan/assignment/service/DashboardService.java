package com.anaplan.assignment.service;

import com.anaplan.assignment.model.Dashboard;
import com.anaplan.assignment.repo.DashboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public List<Dashboard>  getAllDashboards() {
        return dashboardRepository.findAll();
    }
}
