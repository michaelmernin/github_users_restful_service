package com.github.data.gitusers.Models;

public interface ApiConstants {

    String USERNAME = "username";
    String GIT_USER_DATA_RESPONSE = "gitUserDataResponse";
    String GIT_USER_DATA_BODY = "gitUserDataResponseBody";
    String GIT_USER_REPO_DATA_BODIES = "gitUserRepoDataResponseBody";
    int INVALID_REQUEST_STATUS_CODE = 400;
    int NO_USER_FOUND_STATUS_CODE = 404;
    int INTERNAL_ERROR_CODE = 500;
    int SUCCESS_STATUS_CODE = 200;

    // Exception Messages
    String INVALID_USERNAME_LENGTH_MSG = "Github usernames must not exceed {0} characters. Please try again";
    String INVALID_USERNAME_HYPHEN = "Github usernames cannot start with or begin with a hyphen '-'";
}
