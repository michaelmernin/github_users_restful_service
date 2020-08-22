package com.github.data.gitusers.Exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.data.gitusers.Models.ApiConstants;

public class GitHttpException extends RuntimeException {

    @JsonProperty("error")
    String error;

    int statusCode;

    public GitHttpException(String errorMsg, int statusCode){
        this.error = errorMsg;
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return this.statusCode;
    }

    public JsonNode builderrorMsg(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("errorType", "GITHUB error");
        node.put("errorMsg", buildGitHubErrorMsg());
        node.put("fullGitHubMsg", this.error);

        return node;
    }

    public String buildGitHubErrorMsg(){
        if(this.statusCode == ApiConstants.NO_USER_FOUND_STATUS_CODE){
            return "No user found for given username";
        } else {
            return "GITHUB error status code received. Please try again";
        }
    }
}
