package de.tschuehly.svc.ui;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
class SvcUiApplicationTests {

  @Autowired
  MockMvc mockMvc;

  @Test
  void rendersPrecompiledTemplates() throws Exception {
    mockMvc.perform(get("/task/7"))
        .andExpect(status().isOk())
        .andExpect(content().string(Matchers.containsString("new world")));
  }

}
