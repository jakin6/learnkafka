package com.scm.demokafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
   // private final KafkaProperties kafkaProperties;

    public void sendMessage(String msg) {

        log.info(String.format("#### -> Producing message to jakin topic -> %s", msg));
        kafkaTemplate.send("jakin", msg);
    }
}
