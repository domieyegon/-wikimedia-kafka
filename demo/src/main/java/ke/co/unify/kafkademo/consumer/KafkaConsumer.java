package ke.co.unify.kafkademo.consumer;

import ke.co.unify.kafkademo.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "my-topic", groupId = "myGroup")
//    public void consumeMessage(String message){
//        log.info("Request to consume message: {} from producer", message);
//    }
    @KafkaListener(topics = "my-topic", groupId = "myGroup")
    public void consumeMessage(Student student){
        log.info("Request to consume student: {} from producer", student);
    }
}
