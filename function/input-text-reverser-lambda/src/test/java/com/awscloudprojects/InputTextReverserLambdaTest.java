package com.awscloudprojects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.amazonaws.services.lambda.runtime.Context;
import com.awscloudprojects.lambda.InputTextReverserLambda;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputTextReverserLambdaTest {
    private static final Logger logger = LoggerFactory.getLogger(InputTextReverserLambdaTest.class);
    @Test
    public void shouldReturnReversedTextWhenInputTextValid() {
        Map<String, Object> input = new HashMap<>();
        input.put("text", "hello-world");
        Context context = new TestContext();
        InputTextReverserLambda inputTextReverserLambda = new InputTextReverserLambda();
        String response = inputTextReverserLambda.handleRequest(input, context);
        assertNotNull(response);
        assertEquals("dlrow-olleh", response);
    }
    @Test
    public void shouldReturnResponseWhenInputEventNull() {
        Context context = new TestContext();
        InputTextReverserLambda inputTextReverserLambda = new InputTextReverserLambda();
        String response = inputTextReverserLambda.handleRequest(null, context);
        assertNotNull(response);
        assertEquals("Input event is null", response);
    }
    @Test
    public void shouldReturnResponseWhenInputTextNull() {
        Map<String, Object> input = new HashMap<>();
        input.put("text", null);
        Context context = new TestContext();
        InputTextReverserLambda inputTextReverserLambda = new InputTextReverserLambda();
        String response = inputTextReverserLambda.handleRequest(input, context);
        assertNotNull(response);
        assertEquals("Input text is null", response);
    }
}
