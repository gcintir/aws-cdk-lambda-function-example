package com.awscloudprojects;

import software.amazon.awscdk.Duration;
import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.services.iam.ManagedPolicy;
import software.amazon.awscdk.services.iam.Role;
import software.amazon.awscdk.services.iam.ServicePrincipal;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.logs.LogGroup;
import software.amazon.awscdk.services.logs.RetentionDays;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class LambdaStack extends Stack {
    public LambdaStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        Role executionRole = Role.Builder.create(this, id + "-InputTextReverserLambdaRole")
                .assumedBy(new ServicePrincipal("lambda.amazonaws.com"))
                .roleName(id + "-InputTextReverserLambdaRole")
                .build();
        executionRole.addManagedPolicy(ManagedPolicy.fromAwsManagedPolicyName("service-role/AWSLambdaBasicExecutionRole"));

        String functionName = id + "-InputTextReverserLambda";
        Function.Builder.create(this, functionName)
                .runtime(Runtime.JAVA_21)
                .code(Code.fromAsset("../function/input-text-reverser-lambda/target/input-text-reverser-lambda.jar"))
                .handler("com.awscloudprojects.lambda.InputTextReverserLambda::handleRequest")
                .functionName(functionName)
                .role(executionRole)
                .timeout(Duration.seconds(30L))
                .memorySize(512)
                .logGroup(LogGroup.Builder.create(this, functionName + "-logGroup")
                        .logGroupName("/aws/lambda/" + functionName)
                        .retention(RetentionDays.ONE_DAY)
                        .removalPolicy(RemovalPolicy.DESTROY)
                        .build())
                .build();
    }
}
