package com.awscloudprojects;

import software.amazon.awscdk.App;
import software.amazon.awscdk.StackProps;

public class CdkApp {
    public static void main(final String[] args) {
        App app = new App();
        new LambdaStack(app, "LambdaStack", StackProps.builder().build());
        app.synth();
    }
}

