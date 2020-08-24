package com.github.data.gitusers.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseObject {

    @JsonProperty("user_name")
    JsonNode userName;

    @JsonProperty("display_name")
    JsonNode displayName;

    @JsonProperty("avatar")
    JsonNode avatar;

    @JsonProperty("geo_location")
    JsonNode geoLocation;

    @JsonProperty("email")
    JsonNode email;

    @JsonProperty("url")
    JsonNode url;

    @JsonProperty("created_at")
    JsonNode createdAt;

    @JsonProperty("repos")
    List<RepoObject> repos;

    public ResponseObject(ObjectNode userData) throws JsonProcessingException {
        this.userName = userData.get("login");
        this.displayName = userData.get("name");
        this.avatar = userData.get("avatar_url");
        this.geoLocation = userData.get("location");
        this.email = userData.get("email");
        this.url = userData.get("html_url");
        this.setCreatedBy(userData.get("created_at"));
        this.repos = new ArrayList<>();
    }

    public void addRepo(RepoObject repoObject) {
        this.repos.add(repoObject);
    }

    public void setCreatedBy(JsonNode value) throws JsonProcessingException {
        if (!value.isNull()) {
            String date = value.toString();
            String formattedDate = date.replace("T", " ").replace("Z", "");
            ObjectMapper mapper = new ObjectMapper();
            this.createdAt = mapper.readTree(formattedDate);
        } else {
            this.createdAt = value;
        }
    }
}
