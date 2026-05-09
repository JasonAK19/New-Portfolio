package com.portfolio.backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PortfolioController.class)
class PortfolioControllerTest {

@Autowired
private MockMvc mockMvc;

@Test
void returnsPortfolioData() throws Exception {
mockMvc.perform(get("/api/portfolio"))
.andExpect(status().isOk())
.andExpect(jsonPath("$.name").value("Jason"))
.andExpect(jsonPath("$.skills[0]").value("React"))
.andExpect(jsonPath("$.projects[0].name").value("Portfolio Website"));
}
}
