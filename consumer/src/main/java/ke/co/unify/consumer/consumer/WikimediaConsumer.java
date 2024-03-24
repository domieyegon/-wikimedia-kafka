package ke.co.unify.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {
    @KafkaListener(topics = "wiki-media-stream", groupId = "myGroup")
    public void consumeMessage(String message){
        log.info("Request to consume message: {} from Wikimedia Stream", message);
    }
}
