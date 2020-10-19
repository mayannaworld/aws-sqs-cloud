package com.mayanna.awssqscloud.configurations;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;

public class ProducerConfiguration {

    QueueMessagingTemplate queueMessagingTemplate;

    @Bean
    public QueueMessagingTemplate getQueueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
        return queueMessagingTemplate;
    }
}
