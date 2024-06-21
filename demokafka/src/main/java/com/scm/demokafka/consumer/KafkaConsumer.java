package com.scm.demokafka.consumer;

import com.scm.demokafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

    //@KafkaListener(topics = "jakin", groupId = "mygroup")
    public void consumeMsg(String msg){
        log.info(format("Consuming the image from jakin Topic:: %s",msg));
    }

    @KafkaListener(topics = "wikimedia_stream", groupId = "webstream")
    public void consumeJsonMsg(Student student){
        log.info(format("Consuming the image from jakin Topic:: %s",student.toString()));
    }
}
