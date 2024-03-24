package ke.co.unify.kafkademo.producer;

import ke.co.unify.kafkademo.domain.Student;
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

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student student){
        log.info("Sending student to my-topic: {}", student);
        Message<Student> message = MessageBuilder
                .withPayload(student)
                        .setHeader(KafkaHeaders.TOPIC, "my-topic")
                                .build();
        kafkaTemplate.send(message);
    }

}
