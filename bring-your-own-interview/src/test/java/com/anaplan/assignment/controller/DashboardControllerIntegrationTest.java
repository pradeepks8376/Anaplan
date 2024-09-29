package com.anaplan.assignment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DashboardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnDashboardList() throws Exception {
        mockMvc.perform(get("/anaplan/dashboards"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Dashboard1"))
                .andExpect(jsonPath("$[0].createdAt").value("2023-09-15T09:00:00.000+00:00"))
                .andExpect(jsonPath("$[0].updatedAt").value("2023-09-15T09:00:00.000+00:00"));
    }
}
