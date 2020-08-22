package com.github.data.gitusers.Exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class IncorrectParamException extends RuntimeException {

    @JsonProperty("error")
    String error;

    int statusCode;

    public IncorrectParamException(String errorMsg, int statusCode) {
        this.error = errorMsg;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getError() {
        return this.error;
    }

    public JsonNode builderrorMsg() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("errorType", "Incorrect params found");
        node.put("errorMsg", this.error);
        return node;
    }
}
