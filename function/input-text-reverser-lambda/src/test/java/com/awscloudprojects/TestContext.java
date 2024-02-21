package com.awscloudprojects;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class TestContext implements Context {
    public TestContext() {}
    public String getAwsRequestId(){
        return new String("00054321-xmpl-0000-0000-160484189f99");
    }
    public String getLogGroupName(){
        return new String("/aws/lambda/input-text-reverser-function");
    }
    public String getLogStreamName(){
        return new String("2020/02/26/[$LATEST]704f8dxmpla04097b9134246b8438f1a");
    }
    public String getFunctionName(){
        return new String("input-text-reverser-function");
    }
    public String getFunctionVersion(){
        return new String("$LATEST");
    }
    public String getInvokedFunctionArn(){
        return new String("arn:aws:lambda:us-east-1:000000000000:function:input-text-reverser-function");
    }
    public CognitoIdentity getIdentity(){
        return null;
    }
    public ClientContext getClientContext(){
        return null;
    }
    public int getRemainingTimeInMillis(){
        return 300000;
    }
    public int getMemoryLimitInMB(){
        return 512;
    }
    public LambdaLogger getLogger(){
        return new TestLogger();
    }
}
