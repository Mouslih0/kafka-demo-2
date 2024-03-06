package com.example.wikimedia.consomer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {

    @KafkaListener(topics = "wikimedia-topic", groupId = "myGroup")
    public void consumerMsg(String message)
    {
        log.info(String.format("Consuming the message from wiki media stream topic: %s", message));
    }

}
