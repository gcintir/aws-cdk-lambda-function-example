package com.awscloudprojects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.amazonaws.services.lambda.runtime.Context;
import com.awscloudprojects.lambda.InputTextReverserLambda;
import com.awscloudprojects.model.InputText;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputTextReverserLambdaTest {
    private static final Logger logger = LoggerFactory.getLogger(InputTextReverserLambdaTest.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void shouldReturnReversedTextWhenInputTextValid() throws JsonProcessingException {
        InputText inputText = new InputText();
        inputText.setText("hello-world");
        Context context = new TestContext();
        InputTextReverserLambda inputTextReverserLambda = new InputTextReverserLambda();
        String response = inputTextReverserLambda.handleRequest(objectMapper.writeValueAsString(inputText), context);
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
    public void shouldReturnResponseWhenInputTextNull() throws JsonProcessingException {
        InputText inputText = new InputText();
        inputText.setText(null);
        Context context = new TestContext();
        InputTextReverserLambda inputTextReverserLambda = new InputTextReverserLambda();
        String response = inputTextReverserLambda.handleRequest(objectMapper.writeValueAsString(inputText), context);
        assertNotNull(response);
        assertEquals("Input text is null", response);
    }

    @Test
    public void shouldReturnResponseWhenInputEventMalformed() {
        var event = new HashMap<String, Object>();
        event.put("text","test");
        Context context = new TestContext();
        InputTextReverserLambda inputTextReverserLambda = new InputTextReverserLambda();
        String response = inputTextReverserLambda.handleRequest(event, context);
        assertNotNull(response);
    }
}
