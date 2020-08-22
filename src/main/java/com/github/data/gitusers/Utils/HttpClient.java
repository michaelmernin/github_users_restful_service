package com.github.data.gitusers.Utils;

import com.github.data.gitusers.Exceptions.HttpException;
import com.github.data.gitusers.Models.ApiConstants;
import com.github.data.gitusers.Models.OkHTTPResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {
    int INTERNAL_ERROR_CODE = ApiConstants.INTERNAL_ERROR_CODE;
    OkHttpClient client = new OkHttpClient();

    public OkHTTPResponse makeGitRequest(String url) {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return new OkHTTPResponse(response);

        } catch (Exception e) {
            throw new HttpException(e.getMessage(), INTERNAL_ERROR_CODE);
        }
    }


}
