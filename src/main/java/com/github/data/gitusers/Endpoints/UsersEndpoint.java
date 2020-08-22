package com.github.data.gitusers.Endpoints;

import com.github.data.gitusers.Exceptions.GitHttpException;
import com.github.data.gitusers.Exceptions.HttpException;
import com.github.data.gitusers.Exceptions.IncorrectParamException;
import com.github.data.gitusers.Models.ApiConstants;
import com.github.data.gitusers.Processors.ErrorHandler;
import com.github.data.gitusers.Processors.GetUserData;
import com.github.data.gitusers.Utils.ResponseBuilder;
import com.github.data.gitusers.Validations.GetUserDataValidatorBean;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class UsersEndpoint extends RouteBuilder {

    String GET_GIT_USER_DATA_ROUTE = "direct:getGitData";
    String GET_GIT_USER_REPO_DATA_ROUTE = "direct:getGitRepoData";
    String BUILD_RESPONSE = "direct:buildResponse";

    @Override
    public void configure() throws Exception {
        // Exception Handling
        onException(IncorrectParamException.class)
                .handled(true)
                .bean(ErrorHandler.class, ErrorHandler.HANDLE_INCORRECT_PARAM_ERROR)
                .marshal()
                .json(JsonLibrary.Jackson);

        onException(GitHttpException.class)
                .handled(true)
                .bean(ErrorHandler.class, ErrorHandler.HANDLE_GIT_HTTP_EXCEPTION)
                .marshal()
                .json(JsonLibrary.Jackson);

        onException(HttpException.class)
                .handled(true)
                .bean(ErrorHandler.class, ErrorHandler.HANDLE_HTTP_EXCEPTION)
                .marshal()
                .json(JsonLibrary.Jackson);

        // Creating REST configuration
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.off);

        // GET ENDPOINT
        rest("{{BASE_URL}}")
                .get("/username/{username}")
                .route()
                .bean(GetUserDataValidatorBean.class, GetUserDataValidatorBean.VALIDATE_GET_USER_REQUEST)
                .setProperty(ApiConstants.USERNAME, simple(ApiConstants.USERNAME))
                .to(GET_GIT_USER_DATA_ROUTE)
                .to(GET_GIT_USER_REPO_DATA_ROUTE)
                .to(BUILD_RESPONSE);


        // Get user data
        from(GET_GIT_USER_DATA_ROUTE)
                .bean(GetUserData.class, GetUserData.GET_USER_DATA)
                .bean(GetUserDataValidatorBean.class, GetUserDataValidatorBean.VALIDATE_GIT_RESPONSE);

        // Get all repo data
        from(GET_GIT_USER_REPO_DATA_ROUTE)
                .bean(GetUserData.class, GetUserData.GET_USER_REPO_DATA)
                .bean(GetUserDataValidatorBean.class, GetUserDataValidatorBean.VALIDATE_GIT_RESPONSE);

        // Build response with user and user's repo data
        from(BUILD_RESPONSE)
                .bean(ResponseBuilder.class, ResponseBuilder.AGGREGATE_DATA_AND_RETURN)
                .marshal()
                .json(JsonLibrary.Jackson);
    }
}
