package ke.co.unify.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikiMediaTopicConfig {

    @Bean
    public NewTopic wikiMediaStreamTopic(){
        return TopicBuilder
                .name("wiki-media-stream")
                .partitions(5)
                .build();
    }
}
