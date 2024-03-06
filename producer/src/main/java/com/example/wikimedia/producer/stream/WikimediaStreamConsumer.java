package com.example.wikimedia.producer.stream;

import com.example.wikimedia.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer wikimediaProducer;

    public WikimediaStreamConsumer(WebClient.Builder webClient, WikimediaProducer wikimediaProducer) {
        this.webClient = webClient
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.wikimediaProducer = wikimediaProducer;
    }

    public void consumerStreamAndPublish()
    {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikimediaProducer::sendMessage);
    }
}
