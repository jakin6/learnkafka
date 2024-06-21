package com.jk.wikimedia.producer.stream;

import com.jk.wikimedia.producer.producer.WikimediaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *                 WebClient.get()
 *                 .uri("https://stream.wikimedia.org/v2/stream/recentchange")
 *                 .retrieve()
 *                 .bodyToFlux(WikimediaChange.class)
 *                 .subscribe(wikimediaProducer::sendMessage);
 */

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer wikimediaProducer;

    public  WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducer wikimediaProducer) {
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
        this .wikimediaProducer = wikimediaProducer;
    }
//https://stream.wikimedia.org/v2/stream/recentchange
    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
//                .subscribe(log::info);
                .subscribe(wikimediaProducer::sendMessage);
    }


}
