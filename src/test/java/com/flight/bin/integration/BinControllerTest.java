package com.flight.bin.integration;

import com.flight.bin.controller.BinController;
import com.flight.bin.service.BinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BinController.class)
public class BinControllerTest {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private BinService binService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @WithMockUser("bins")
    @Test
    public void bins() throws Exception {

        // given - precondition or setup
        List<String> expected = List.of("bin-a", "bin-b");
        when(binService.bins()).thenReturn(expected);

        mockMvc.perform(get("/bins"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

}
