package com.jk.wikimedia.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class WikimediaConsumer {
    @KafkaListener(topics = "wikimedia_stream", groupId = "webstream")
    public void consumeMsg(String msg){
        log.info(format("Consuming the image from wikimedia_strean Topic:: %s",msg));
        //please feel free tp do anything you want with the data
    }
}
