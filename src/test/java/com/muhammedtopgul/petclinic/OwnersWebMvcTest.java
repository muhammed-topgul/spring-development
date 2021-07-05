package com.muhammedtopgul.petclinic;

/*
 * created by Muhammed Topgul
 * on 05/07/2021
 * at 23:19
 */

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@WithMockUser(username = "user", password = "secret", authorities = "USER")
public class OwnersWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testOwners() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mvc/owners");

        ResultActions resultActions = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = resultActions.andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        assert modelAndView != null;
        MatcherAssert.assertThat(modelAndView.getViewName(), Matchers.equalTo("owners"));
        MatcherAssert.assertThat(modelAndView.getModel().containsKey("owners"), Matchers.is(true));
    }
}
