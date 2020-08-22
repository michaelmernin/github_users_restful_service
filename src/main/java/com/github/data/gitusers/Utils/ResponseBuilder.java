package com.github.data.gitusers.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.data.gitusers.Models.ApiConstants;
import com.github.data.gitusers.Models.RepoObject;
import com.github.data.gitusers.Models.ResponseObject;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ResponseBuilder {

    public static final String AGGREGATE_DATA_AND_RETURN = "buildResponse";

    public void buildResponse(Exchange exchange) throws JsonProcessingException {
        ObjectNode userData = (ObjectNode) exchange.getProperty(ApiConstants.GIT_USER_DATA_BODY);
        List<ObjectNode> userRepos = (List<ObjectNode>) exchange.getProperty(ApiConstants.GIT_USER_REPO_DATA_BODIES);
        ResponseObject responseObject = new ResponseObject(userData);
        userRepos.forEach(repo -> responseObject.addRepo(new RepoObject(repo.get("name"), repo.get("url"))));
        exchange.getOut().setBody(responseObject);
        exchange.getOut().setHeader("CamelHttpResponseCode", ApiConstants.SUCCESS_STATUS_CODE);
        exchange.getOut().setHeader("Content-Type", "application/json");
    }
}
