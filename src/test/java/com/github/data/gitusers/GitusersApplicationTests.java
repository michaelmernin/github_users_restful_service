package com.github.data.gitusers;

import com.github.data.gitusers.Exceptions.IncorrectParamException;
import com.github.data.gitusers.Models.ApiConstants;
import com.github.data.gitusers.Validations.GetUserDataValidatorBean;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class GitusersApplicationTests {

    int MAX_USERNAME_LENGTH = 39;
    GetUserDataValidatorBean validatorBean = new GetUserDataValidatorBean();
    CamelContext camelContext = new DefaultCamelContext();
    Exchange exchange = new DefaultExchange(camelContext);

    @Test
    void contextLoads() {
    }

    @Test
    void paramValidation_invalidUsernameLength() {
        String invalidUsername = String.join("x", Collections.nCopies(MAX_USERNAME_LENGTH + 1, "x"));
        exchange.setProperty(ApiConstants.USERNAME, invalidUsername);
        try {
            validatorBean.validateGetUserRequest(exchange, invalidUsername);
        } catch (IncorrectParamException e) {
            assert e.getStatusCode() == ApiConstants.INVALID_REQUEST_STATUS_CODE;
        }
    }

    @Test
    void paramValidation_invalidUsernameHyphen() {
        String invalidUsername = "-namestarting";
        exchange.setProperty(ApiConstants.USERNAME, invalidUsername);
        try {
            validatorBean.validateGetUserRequest(exchange, invalidUsername);
        } catch (IncorrectParamException e) {
            assert e.getStatusCode() == ApiConstants.INVALID_REQUEST_STATUS_CODE;
        }
    }

}
