package com.github.data.gitusers.Validations;

import com.github.data.gitusers.Exceptions.GitHttpException;
import com.github.data.gitusers.Exceptions.IncorrectParamException;
import com.github.data.gitusers.Models.ApiConstants;
import com.github.data.gitusers.Models.OkHTTPResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;

@Service
public class GetUserDataValidatorBean {

    @Value("${github.maximum.username.length}")
    int MAX_USERNAME_LENGTH;
    String INVALID_USERNAME_LENGTH_MSG = ApiConstants.INVALID_USERNAME_LENGTH_MSG;
    int INVALID_REQUEST_STATUS_CODE = ApiConstants.INVALID_REQUEST_STATUS_CODE;

    public static final String VALIDATE_GET_USER_REQUEST = "validateGetUserRequest";
    public static final String VALIDATE_GIT_RESPONSE = "validateGitResponse";

    public void validateGetUserRequest(Exchange exchange, @Header(ApiConstants.USERNAME) String username) {
        if (username.length() > MAX_USERNAME_LENGTH) {
            throw new IncorrectParamException(MessageFormat.format(INVALID_USERNAME_LENGTH_MSG, MAX_USERNAME_LENGTH), INVALID_REQUEST_STATUS_CODE);
        }
        if(username.startsWith("-") || username.endsWith("-")){
            throw new IncorrectParamException(ApiConstants.INVALID_USERNAME_HYPHEN, INVALID_REQUEST_STATUS_CODE);
        }

    }

    public void validateGitResponse(Exchange exchange, @Header(ApiConstants.GIT_USER_DATA_RESPONSE) OkHTTPResponse response) throws IOException {
        if (response.getStatusCode() != 200) {
            throw new GitHttpException(response.getResponseBody(), response.getStatusCode());
        }
    }

}
