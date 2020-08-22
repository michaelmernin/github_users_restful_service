package com.github.data.gitusers.Processors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.github.data.gitusers.Models.ApiConstants;
import com.github.data.gitusers.Models.OkHTTPResponse;
import com.github.data.gitusers.Utils.HttpClient;
import com.github.data.gitusers.Validations.GetUserDataValidatorBean;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetUserData {
    @Value(("${github.endpoint.users}"))
    String GIT_USERS_ENDPOINT;

    @Value(("${github.endpoint.repos}"))
    String GIT_USERS_REPO_ENDPOINT;

    @Autowired
    HttpClient httpClient;

    @Autowired
    GetUserDataValidatorBean getUserDataValidatorBean;

    public static final String GET_USER_DATA = "getUserData";
    public static final String GET_USER_REPO_DATA = "getUserRepoData";


    public void getUserData(Exchange exchange, @Header(ApiConstants.USERNAME) String username) throws IOException {
        String custUrl = GIT_USERS_ENDPOINT + username;
        OkHTTPResponse response = httpClient.makeGitRequest(custUrl);
        exchange.setProperty(ApiConstants.GIT_USER_DATA_RESPONSE, response);
        exchange.setProperty(ApiConstants.GIT_USER_DATA_BODY, convertGitUserBody(response));
    }

    public void getUserRepoData(Exchange exchange, @Header(ApiConstants.USERNAME) String username) throws IOException {
        int pageNumber = 1;
        OkHTTPResponse response;
        List<ObjectNode> gitResponseBodies = new ArrayList<>();
        while (true) {
            String url = GIT_USERS_ENDPOINT + username + GIT_USERS_REPO_ENDPOINT + pageNumber;
            response = httpClient.makeGitRequest(url);
            getUserDataValidatorBean.validateGitResponse(exchange, response);
            if (convertGitRepoBody(response).size() == 0) {
                break;
            }
            gitResponseBodies.addAll(convertGitRepoBody(response));
            pageNumber++;
        }
        exchange.setProperty(ApiConstants.GIT_USER_REPO_DATA_BODIES, gitResponseBodies);
    }

    public ObjectNode convertGitUserBody(OkHTTPResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getResponseBody(), ObjectNode.class);
    }

    public List<ObjectNode> convertGitRepoBody(OkHTTPResponse response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        return objectMapper.readValue(response.getResponseBody(), typeFactory.constructCollectionType(List.class, ObjectNode.class));
    }

}
