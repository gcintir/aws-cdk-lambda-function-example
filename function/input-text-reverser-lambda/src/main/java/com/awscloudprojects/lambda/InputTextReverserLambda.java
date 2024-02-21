package com.awscloudprojects.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.awscloudprojects.model.InputText;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.lambda.powertools.logging.Logging;

public class InputTextReverserLambda implements RequestHandler<Object, String> {

    private static final Logger logger = LoggerFactory.getLogger(InputTextReverserLambda.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    @Logging(logEvent = true, clearState = true)
    public String handleRequest(Object input, Context context) {
        String response;
        try {
            if (Objects.isNull(input)) {
                return "Input event is null";
            }
            InputText inputText = objectMapper.readValue((String) input, InputText.class);
            if (Objects.isNull(inputText.getText())) {
                return "Input text is null";
            }
            response = new StringBuilder(inputText.getText()).reverse().toString();
            logger.info("received text: {} response: {}", inputText.getText(), response);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = e.getMessage();
        }
        return response;
    }
}

