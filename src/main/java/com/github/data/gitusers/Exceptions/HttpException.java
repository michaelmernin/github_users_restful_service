package com.github.data.gitusers.Exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class HttpException extends RuntimeException {

    @JsonProperty("error")
    String error;

    int statusCode;

    public HttpException(String errorMsg, int statusCode){
        this.error = errorMsg;
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return this.statusCode;
    }

    public JsonNode builderrorMsg(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("errorType", "Issues connecting to GITHUB. Please try again");
        node.put("errorMsg", this.error);
        return node;
    }
}
