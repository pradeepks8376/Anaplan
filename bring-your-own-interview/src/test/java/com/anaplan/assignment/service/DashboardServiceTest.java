package com.anaplan.assignment.service;

import com.anaplan.assignment.exception.DashboardNotFoundException;
import com.anaplan.assignment.model.Dashboard;
import com.anaplan.assignment.repo.DashboardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DashboardServiceTest {

    @Mock
    private DashboardRepository dashboardRepository;

    @InjectMocks
    private DashboardService dashboardService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDashboardById_NotFound() throws Exception {
        mockMvc.perform(get("/anaplan/dashboards", 99L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Dashboard not found with id: 99"));
    }

/*    @Test(expected = DashboardNotFoundException.class)
    void shouldReturnDashboardListWhenAvailable() {
        List<Dashboard> mockDashboards = List.of(new Dashboard(1L, "Test Dashboard", new Date(), new Date()));
        Mockito.when(dashboardRepository.findAll()).thenReturn(mockDashboards);

        List<Dashboard> result = dashboardService.getAllDashboards();

        assertEquals(1, result.size());
        assertEquals("Test Dashboard", result.get(0).getTitle());
    }*/

    @Test
    void shouldReturnDashboardListWhenAvailable() {
        List<Dashboard> mockDashboards = List.of(new Dashboard(1L, "Test Dashboard", new Date(), new Date()));
        Mockito.when(dashboardRepository.findAll()).thenReturn(mockDashboards);

        List<Dashboard> result = dashboardService.getAllDashboards();

        assertEquals(1, result.size());
        assertEquals("Test Dashboard", result.get(0).getTitle());
    }

}
