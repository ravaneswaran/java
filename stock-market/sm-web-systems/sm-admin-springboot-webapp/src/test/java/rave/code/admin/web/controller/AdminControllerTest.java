package rave.code.admin.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;   // simulate HTTP requests

    @Test
    public void testHomePage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("list_nse_triggers"));
    }

    @Test
    public void testListJobs() throws Exception{
        this.mockMvc.perform(get("/nse/jobs"))
                .andExpect(status().isOk())
                .andExpect(view().name("list_nse_jobs"));
    }

    @Test
    public void testListTriggers() throws Exception{
        this.mockMvc.perform(get("/nse/triggers"))
                .andExpect(status().isOk())
                .andExpect(view().name("list_nse_triggers"))
                .andExpect(model().attribute("webpage", hasProperty("modelList", notNullValue())));
    }
}
