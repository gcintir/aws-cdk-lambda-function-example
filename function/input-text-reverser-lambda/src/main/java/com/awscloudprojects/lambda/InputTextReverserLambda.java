package com.awscloudprojects.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputTextReverserLambda implements RequestHandler<Object, String> {

    private static final Logger logger = LoggerFactory.getLogger(InputTextReverserLambda.class);
    @Override
    public String handleRequest(Object input, Context context) {
        return null;
    }
}

