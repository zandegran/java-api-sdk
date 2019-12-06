package com.smartling.api.v2.client.exception.client;

import com.smartling.api.v2.response.ErrorResponse;

import javax.ws.rs.core.Response;

public class TooManyRequestsException extends ClientApiException
{
    public TooManyRequestsException(Throwable cause, Response response, ErrorResponse errorResponse)
    {
        super(cause, response, errorResponse);
    }
}
