package ke.co.unify.kafkademo.web.rest;

import ke.co.unify.kafkademo.domain.Student;
import ke.co.unify.kafkademo.producer.KafkaJsonProducer;
import ke.co.unify.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
@Slf4j
public class MessageResource {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        log.info("REST request to send message: {} to kafka produce", message);
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().body("Message queued successfully");
    }

    @PostMapping("/student")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
        log.info("REST request to send student: {} to kafka produce", student);
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok().body("Message queued successfully as JSON");
    }
}
