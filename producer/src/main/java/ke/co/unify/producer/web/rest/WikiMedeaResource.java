package ke.co.unify.producer.web.rest;

import ke.co.unify.producer.stream.WikiMediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class WikiMedeaResource {

    private final WikiMediaStreamConsumer wikiMediaStreamConsumer;

    @GetMapping
    public void startPublishing() {
        wikiMediaStreamConsumer.consumeStreamAndPublish();
    }
}
