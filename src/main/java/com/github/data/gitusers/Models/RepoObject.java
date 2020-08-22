package com.github.data.gitusers.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepoObject {

    @JsonProperty("name")
    JsonNode name;

    @JsonProperty("url")
    JsonNode url;

    public RepoObject(JsonNode name, JsonNode url) {
        this.name = name;
        this.url = url;
    }
}
