package com.awscloudprojects.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.lambda.powertools.logging.Logging;

public class InputTextReverserLambda implements RequestHandler<Map<String, Object>, String> {

    private static final Logger logger = LoggerFactory.getLogger(InputTextReverserLambda.class);

    @Override
    @Logging(logEvent = true, clearState = true)
    public String handleRequest(Map<String, Object> input, Context context) {
        String response;
        try {
            if (Objects.isNull(input)) {
                return "Input event is null";
            }
            if (Objects.isNull(input.get("text"))) {
                return "Input text is null";
            }
            String inputText = (String) input.get("text");
            response = new StringBuilder(inputText).reverse().toString();
            logger.info("received text: {} response: {}", inputText, response);

        } catch (Exception e) {
            logger.error(e.getMessage());
            response = e.getMessage();
        }
        return response;
    }
}

