package com.anaplan.assignment.controller;

import com.anaplan.assignment.exception.DashboardNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anaplan.assignment.service.DashboardService;
import com.anaplan.assignment.model.Dashboard;

import java.util.List;

@RestController
@RequestMapping("/anaplan")

public class DashboardController {

    @Autowired
    private final DashboardService dashboardService;

    public DashboardController (DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @Operation(summary = "Get a list of all dashboards", description = "Returns a list of dashboard objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/dashboards")
    public ResponseEntity<List<Dashboard>>  getDashboards() {
        List<Dashboard> dashboards = dashboardService.getAllDashboards();
        if (dashboards == null || dashboards.isEmpty()) {
            throw new DashboardNotFoundException("No dashboard found: ");
        }
        return ResponseEntity.ok(dashboards);
    }

}
