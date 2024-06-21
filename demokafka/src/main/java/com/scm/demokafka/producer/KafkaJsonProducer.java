package com.scm.demokafka.producer;

import com.scm.demokafka.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer {
    private final KafkaTemplate<String,Student>kafkaTemplate;
    public void sendMessage(Student student){
        Message<Student> message = MessageBuilder
                    .withPayload(student)
                            .setHeader(KafkaHeaders.TOPIC,"jakin")
                                    .build();
        kafkaTemplate.send(message);
    }
//        log.info(String.format("#### -> Producing message to jakin topic -> %s", msg));
//        kafkaTemplate.send("jakin", msg);
//    }

}
