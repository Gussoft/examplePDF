package com.gussoft.utils;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.pinpoint.AmazonPinpoint;
import com.amazonaws.services.pinpoint.AmazonPinpointClientBuilder;
import com.amazonaws.services.pinpoint.model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProcessSMS {
    private static final String accessKey = "";
    private static final String secretKey = "";

    public static void main(String[] args) throws IOException {

        ProcessSMS processSMS = new ProcessSMS();
        processSMS.send();
    }

    private AmazonPinpoint amazonPinpoint;

    private static String originationNumber = "+51932111015";

    private static String destinationNumber = "+51914288347";

    private static String message = "This message was sent through Amazon Pinpoint "
            + "using the AWS SDK for Java. Reply STOP to "
            + "opt out.";

    public static String appId = "50377c1ee2bd4ff89cf141617b6b853f";
    public static String messageType = "TRANSACTIONAL";

    public static String registeredKeyword = "myKeyword";

    public static String senderId = "MySenderID";

    public void send() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonPinpointClientBuilder.standard().
                withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).
                withRegion(Regions.fromName("us-east-1"))
                .build();

        try {
            Map<String, AddressConfiguration> addressMap =
                    new HashMap<String,AddressConfiguration>();

            addressMap.put(destinationNumber, new AddressConfiguration()
                    .withChannelType(ChannelType.SMS));

            SendMessagesRequest request = new SendMessagesRequest()
                    .withApplicationId(appId)
                    .withMessageRequest(new MessageRequest()
                            .withAddresses(addressMap)
                            .withMessageConfiguration(new DirectMessageConfiguration()
                                    .withSMSMessage(new SMSMessage()
                                            .withBody(message)
                                            .withMessageType(messageType)
                                            .withOriginationNumber(originationNumber)
                                            .withSenderId(senderId)
                                            .withKeyword(registeredKeyword)
                                    )
                            )
                    );
            System.out.println("Sending message...");
            amazonPinpoint.sendMessages(request);
            System.out.println("Message sent!");
        } catch (Exception ex) {
            System.out.println("The message wasn't sent. Error message: "
                    + ex.getMessage());
        }
    }
}
