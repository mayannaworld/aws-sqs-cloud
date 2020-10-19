package com.mayanna.awssqscloud.controller;

import com.mayanna.awssqscloud.model.Movie;
import com.mayanna.awssqscloud.service.SqsQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SqsController {

    private SqsQueueService sqsQueueService;

    @Autowired
    public SqsController(SqsQueueService sqsQueueService) {
        this.sqsQueueService = sqsQueueService;
    }

    @PostMapping(value = "/sendMessage/{topic}")
    public String sendMessage(@PathVariable String topic, @RequestBody Movie movie) {

        try {
            sqsQueueService.send(topic, movie);
        } catch (Exception e) {
            return "Failed with Exception " + e.getMessage();
        }
        return "success";

    }

    @GetMapping(value = "/getMessage/{topic}")
    public String getMessage(@PathVariable String topic) {

        try {
           return sqsQueueService.receive(topic);
        } catch (Exception e) {
            return "Failed with Exception " + e.getMessage();
        }

    }

}
