package com.example.kafka.consumer;

import com.example.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    //@KafkaListener(topics = "alibou", groupId = "myGroup")
    public void consumerMsg(String message)
    {
        log.info(String.format("Consuming the message from alibou topic: %s", message));
    }

    @KafkaListener(topics = "alibou", groupId = "myGroup")
    public void consumerJsonMsg(Student student)
    {
        log.info(String.format("Consuming the message from alibou topic: %s", student.toString()));
    }
}
