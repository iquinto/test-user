package edu.uoc.pds.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uoc.pds.user.application.rest.AuthenticationRESTController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest(classes = UserApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthenticationRESTControllerIntegrationTest {

    private MockMvc mockMvc;
    @Autowired protected WebApplicationContext webApplicationContext;

    private static final String REST_AUTH_PATH = "/auth/";
    private static final String TEST_EMAIL = "isaquinto@uoc.edu";
    private static final String NEW_TEST_EMAIL = "loremipsum@uoc.edu";

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("verify if users can login in the system")
    public void signIn() throws Exception {
        mockMvc.perform(post(REST_AUTH_PATH + "signin")
                        .content(LOGIN_REQUEST())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(AuthenticationRESTController.class))
                .andExpect(handler().methodName("signIn"))
                .andExpect(jsonPath("$.email", equalTo(TEST_EMAIL)));
    }

    @Test
    @DisplayName("verify if users (buyers) can register in the system")
    public void registerBuyer() throws Exception {
        mockMvc.perform(post(REST_AUTH_PATH + "signup" )
                        .content(CREATE_USER_REQUEST())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(handler().handlerType(AuthenticationRESTController.class))
                .andExpect(handler().methodName("registerBuyer"));
    }


    static String LOGIN_REQUEST() throws JsonProcessingException {
        String inputString = "{\n" +
                "   \"email\": \""+TEST_EMAIL+"\",\n" +
                "   \"password\": \"the-password\"\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        Object jsonString = mapper.readValue(inputString, Object.class);

        return mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonString);
    }

    static String CREATE_USER_REQUEST() throws JsonProcessingException {
        String inputString = "{\n" +
                "\t\"user\": {\n" +
                "    \"id\": 1,\n" +
                "    \"fullName\": \"Lorem Ipsum\",\n" +
                "    \"password\": \"loremipsum\",\n" +
                "    \"email\": \""+NEW_TEST_EMAIL+"\",\n" +
                "    \"mobileNumber\": \"600275567\",\n" +
                "    \"roles\": [ {\"name\": \"ROLE_USER\"}\n" +
                "    \t]\n" +
                "\t}\t\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        Object jsonString = mapper.readValue(inputString, Object.class);

        return mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonString);
    }


}