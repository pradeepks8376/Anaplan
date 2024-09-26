package com.anaplan.assignment.service;

import com.anaplan.assignment.model.Dashboard;
import com.anaplan.assignment.repo.DashboardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DashboardServiceTest {

    @Mock
    private DashboardRepository dashboardRepository;

    @InjectMocks
    private DashboardService dashboardService;

    @Test
    void shouldReturnDashboardListWhenAvailable() {
        List<Dashboard> mockDashboards = List.of(new Dashboard(1L, "Test Dashboard", new Date(), new Date()));
        Mockito.when(dashboardRepository.findAll()).thenReturn(mockDashboards);

        List<Dashboard> result = dashboardService.getAllDashboards();

        assertEquals(1, result.size());
        assertEquals("Test Dashboard", result.get(0).getTitle());
    }
}
