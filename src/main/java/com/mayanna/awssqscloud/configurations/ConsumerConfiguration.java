package com.mayanna.awssqscloud.configurations;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfiguration {


    @Bean
    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(AmazonSQSAsync amazonSqs) {
        SimpleMessageListenerContainerFactory msgListenerContainerFactory = new SimpleMessageListenerContainerFactory();
        msgListenerContainerFactory.setAmazonSqs(amazonSqs);
        msgListenerContainerFactory.setMaxNumberOfMessages(5);
        msgListenerContainerFactory.setWaitTimeOut(19);
        msgListenerContainerFactory.setVisibilityTimeout(19);
        return msgListenerContainerFactory;
    }

}
