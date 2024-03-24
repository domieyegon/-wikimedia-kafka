package ke.co.unify.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikiMediaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Sending message to Topic: {}", message);
        kafkaTemplate.send("wiki-media-stream",message);
    }

}
