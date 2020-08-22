package com.github.data.gitusers.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class OkHTTPResponse {
    int statusCode;
    String responseBody;
    String message;
    String urlUsed;

    public OkHTTPResponse(Response response) throws IOException {
        this.statusCode = response.code();
        this.responseBody = Objects.requireNonNull(response.body()).string();
        this.message = response.message();
        this.urlUsed = response.request().url().toString();
    }
}
