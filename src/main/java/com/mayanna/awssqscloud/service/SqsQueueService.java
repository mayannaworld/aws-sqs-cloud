package com.mayanna.awssqscloud.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.mayanna.awssqscloud.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SqsQueueService {

    private final QueueMessagingTemplate queueMessagingTemplate;

    public SqsQueueService(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public void send(String topic, Movie movie) {
        System.out.println(movie);
        queueMessagingTemplate.send(topic, MessageBuilder.withPayload(movie).build());
    }

    public String receive(String topic) {

        return queueMessagingTemplate.receiveAndConvert(topic, String.class);
    }

    @SqsListener("movies")
    public void receiveMessage(String movie,
                               @Header("SenderId") String senderId) {

        System.out.println(movie + " sender id :" + senderId);
    }
}
