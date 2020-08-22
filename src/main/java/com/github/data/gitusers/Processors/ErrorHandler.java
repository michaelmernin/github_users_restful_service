package com.github.data.gitusers.Processors;

import com.github.data.gitusers.Exceptions.GitHttpException;
import com.github.data.gitusers.Exceptions.HttpException;
import com.github.data.gitusers.Exceptions.IncorrectParamException;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangeProperty;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandler {

    public static String HANDLE_INCORRECT_PARAM_ERROR = "handleIncorrectParamException";
    public static String HANDLE_GIT_HTTP_EXCEPTION = "handleGitHttpException";
    public static String HANDLE_HTTP_EXCEPTION = "handleHttpException";

    public void handleIncorrectParamException(@ExchangeProperty("CamelExceptionCaught") IncorrectParamException exception, Exchange exchange) {
        exchange.getOut().setBody(exception.builderrorMsg());
        exchange.getOut().setHeader("CamelHttpResponseCode", exception.getStatusCode());
        exchange.getOut().setHeader("Content-Type", "application/json");
    }

    public void handleGitHttpException(@ExchangeProperty("CamelExceptionCaught") GitHttpException exception, Exchange exchange) {
        exchange.getOut().setBody(exception.builderrorMsg());
        exchange.getOut().setHeader("CamelHttpResponseCode", exception.getStatusCode());
        exchange.getOut().setHeader("Content-Type", "application/json");
    }

    public void handleHttpException(@ExchangeProperty("CamelExceptionCaught") HttpException exception, Exchange exchange) {
        exchange.getOut().setBody(exception.builderrorMsg());
        exchange.getOut().setHeader("CamelHttpResponseCode", exception.getStatusCode());
        exchange.getOut().setHeader("Content-Type", "application/json");
    }

}
