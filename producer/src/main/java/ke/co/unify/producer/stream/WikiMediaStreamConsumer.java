package ke.co.unify.producer.stream;

import ke.co.unify.producer.producer.WikiMediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikiMediaStreamConsumer {

    private final WebClient webClient;
    private final WikiMediaProducer wikiMediaProducer;


    public WikiMediaStreamConsumer(WebClient.Builder webClientBuilder, WikiMediaProducer wikiMediaProducer) {
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
        this.wikiMediaProducer = wikiMediaProducer;
    }

    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikiMediaProducer::sendMessage);
    }
}
