package com.anaplan.assignment.service;

import com.anaplan.assignment.model.Dashboard;
import com.anaplan.assignment.repo.DashboardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public List<Dashboard>  getAllDashboards() {
        log.info("In DashboardService - getAllDashboards");
        return dashboardRepository.findAll();
    }
}
