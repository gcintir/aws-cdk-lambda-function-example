package com.awscloudprojects;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger implements LambdaLogger {
    private static final Logger logger = LoggerFactory.getLogger(TestLogger.class);

    @Override
    public void log(String s) {
    }

    @Override
    public void log(byte[] bytes) {
    }
}