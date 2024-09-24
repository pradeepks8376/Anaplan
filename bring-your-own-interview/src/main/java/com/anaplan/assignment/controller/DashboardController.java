package com.anaplan.assignment.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public List<Dashboard> getDashboards() {
       return dashboardService.getAllDashboards();
    }

}
