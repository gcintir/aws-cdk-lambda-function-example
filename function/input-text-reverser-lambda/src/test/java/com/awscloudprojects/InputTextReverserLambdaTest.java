package com.awscloudprojects;

import static org.junit.Assert.assertNull;
import com.amazonaws.services.lambda.runtime.Context;
import com.awscloudprojects.lambda.InputTextReverserLambda;
import java.util.HashMap;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputTextReverserLambdaTest {
    private static final Logger logger = LoggerFactory.getLogger(InputTextReverserLambdaTest.class);

    @Test
    public void shouldReturnNull()
    {
        logger.info("Running test");
        var event = new HashMap<String,String>();
        Context context = new TestContext();
        InputTextReverserLambda inputTextReverserLambda = new InputTextReverserLambda();
        assertNull(inputTextReverserLambda.handleRequest(event, context));
    }
}
