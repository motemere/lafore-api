package me.motemere.laforeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class LaforeApiApplicationTests {

  protected MockMvc mvc;

  @Autowired
  WebApplicationContext webApplicationContext;

  @BeforeEach
  protected void setUp() {
    mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @DisplayName("Test sort array")
  public void sort() throws Exception {
    String json = "[\"1\",\"0\",\"2\"]";

    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/array/sort")
        .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);

    String content = mvcResult.getResponse().getContentAsString();
    assertEquals(content, "[0,1,2]");
  }

  @Test
  @DisplayName("Test ping")
  public void ping() throws Exception {
    String response = "Pong!";

    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/array/ping")).andReturn();

    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);

    String content = mvcResult.getResponse().getContentAsString();
    assertEquals(content, response);
  }

  @Test
  @DisplayName("Test custom AppConfiguration")
  public void testAppConfiguration() {
    assertEquals("TEST", AppConfiguration.getInstance().get("app.config"));
  }
  
}
